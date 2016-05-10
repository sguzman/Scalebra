package org.github.sguzman.scala.game.scalebra.mvc.view

import java.util.concurrent.Executors

import akka.actor.{Actor, ActorLogging}
import org.github.sguzman.scala.game.scalebra.actor.{Start, Stop}
import org.github.sguzman.scala.game.scalebra.mvc.model.Direction
import org.github.sguzman.scala.game.scalebra.mvc.model.artifact.Food
import org.github.sguzman.scala.game.scalebra.mvc.model.artifact.snake.Snake
import org.lwjgl.opengl.{Display, DisplayMode, GL11}

/**
  * @author Salvador Guzman
  * custom.user: sguzman
  * custom.project: Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.view
  * @note This component represents the view aspect of the MVC model. It
  *          handles all the logistics of representing any visual aspect of the
  *          game. Preferably, it will have a thread to itself that will handle
  *          the communication with LWJGL's visual aspects, like calling the
  *          Display.* methods.
  *
  * custom.created: 5/5/16 2:29 AM
  * @since 5/5/16
  */
class View extends Actor with ActorLogging {
  /** Contains the snake and its body */
  val snake = new Snake

  /** Food */
  var food = Food()

  /**
    * Render entire scene
    */
  def render(): Unit = {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
    snake.render()
    food.render()
  }

  class RenderTh extends Runnable {
      /**
      * Main logic of rendering thread
      */
     def run() = {
      while (!Display.isCloseRequested) {
        do {
          FPS.updateFPS()
          render()
        } while (View.paused)
        Display.update(false)
        Display.sync(60)
      }
    }
 }

  /**
    * Akka actor mailbox for View subsystem
    */
  override def receive: Actor.Receive = {
    case _: Start =>
      View.init()
      View.rendTh.execute(new RenderTh)
    case _: Stop =>
      Display.destroy()
      View.rendTh.shutdown()
    case dir: Direction => if(!View.paused) snake.setDir(dir)
    case pause.TogglePause => View.pauseToggle()
  }
}

object View {
  /** Rendering thread */
  val rendTh = Executors.newSingleThreadExecutor()

  /** Is the game paused? */
  @volatile private var paused = false

  /** Hard code width and height */
  val width = 800
  val height = 600

  /** Contain entire grid */
  val allArea = (for (j <- 0 to (height / 10); i <- 0 to (width / 10))
    yield (i,j)).toSet

  /**
    * Init all subsystems
    */
  def init(): Unit = {
    View.initLWJGL()
    View.initGL()
    FPS.init()
  }

  /**
    * Initiate JWJGL subsystem
    */
  def initLWJGL(): Unit = {
    Display.setDisplayMode(new DisplayMode(800, 600))
    Display.create()
  }

  /**
    * Initialize OpenGL draw subsystem
    */
  def initGL(): Unit = {
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0.0f, width, 0.0f, height, 1.0f, -1.0f)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
  }

  /**
    * Set title text
    */
  def title(msg: String): Unit = Display.setTitle(msg)

  /**
    * Pause the game
    */
  def pause(): Unit = paused = true

  /**
    * Unpause the game
    */
  def unPause(): Unit = paused = false

  /**
    * Toggle pause of the game
    */
  def pauseToggle(): Unit = paused = !paused
}

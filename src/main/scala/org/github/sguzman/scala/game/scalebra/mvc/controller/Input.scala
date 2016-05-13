package org.github.sguzman.scala.game.scalebra.mvc.controller

import java.util.concurrent.Executors

import akka.actor.{Actor, ActorLogging}
import org.github.sguzman.scala.game.scalebra.actor.{Start, Stop}
import org.github.sguzman.scala.game.scalebra.mvc.controller.schema.ControlS
import org.github.sguzman.scala.game.scalebra.util.log.L
import org.lwjgl.input.Keyboard

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.controller
  * @note This class will handle input. It will have it own thread for doing so.
  *       The way this will work depends on LWJGL's Keyboard event buffer. It will
  *       process all Keyboard related events and then sleep. Then, at the beginning
  *       of each render iteration, the render thread will wake the input thread
  *       up.
  * @since 5/7/16 9:29 PM
  */
class Input extends Actor
  with ActorLogging {
  val control = new ControlS
   class InputTh extends Runnable {
    override def run(): Unit = {
      L.i("Input thread running...", "Input")
      while (true) {
        while (Keyboard.next()) {
          control.action()
        }
        wait(0, 500)
      }
    }
  }

  override def receive: Receive = {
    case _: Start =>
      L.i("Start up input thread", "Input")
      Input.inputTh.execute(new InputTh)
    case _: Stop =>
      L.i("Shutdown input thread", "Input")
      Input.inputTh.shutdown()
  }
}

object Input {
  /** Input thread */
  val inputTh = Executors.newSingleThreadExecutor()
}
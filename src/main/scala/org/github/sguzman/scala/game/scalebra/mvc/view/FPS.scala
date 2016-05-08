package org.github.sguzman.scala.game.scalebra.mvc.view

import org.lwjgl.Sys
import org.lwjgl.opengl.Display

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.view
  * @note This class holds all functionality needed to compute the FPS
  * @since 5/7/16 8:38 PM
  */
object FPS {
  /** time at last frame */
  var lastFrame: Long = 0L
  /** frames per second */
  var fps: Int = 0
  /** last fps time */
  var lastFPS: Long = 0L

  /**
    * Get the accurate system time
    *
    * @return The system time in milliseconds
    */
  def getTime: Long = {
    (Sys.getTime * 1000) / Sys.getTimerResolution
  }

  /**
    * Calculate the FPS and set it in the title bar
    */
  def updateFPS(): Unit = {
    if (getTime - lastFPS > 1000) {

      Display.setTitle("FPS: " + fps)
      fps = 0
      lastFPS += 1000
    }
    fps += 1
  }

  /**
    * Calculate how many milliseconds have passed
    * since last frame.
    *
    * @return milliseconds passed since last frame
    */
  def getDelta: Int = {
    val time: Long = getTime
    val delta: Int = (time - lastFrame).toInt
    lastFrame = time
    delta
  }

}

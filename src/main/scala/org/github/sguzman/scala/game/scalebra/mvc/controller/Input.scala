package org.github.sguzman.scala.game.scalebra.mvc.controller

import org.github.sguzman.scala.game.scalebra.mvc.controller.schema.SchemaControl
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
class Input(control: SchemaControl) extends Runnable {
  override def run(): Unit = {
    while (true) {
      while (Keyboard.next()) {
        control.action()
      }
      wait(0, 500)
    }
  }
}

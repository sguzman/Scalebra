package org.github.sguzman.scala.game.scalebra.mvc.controller.schema

import org.github.sguzman.scala.game.scalebra.mvc.model.{Model, Down, Left, Right, Up, Direction}
import org.github.sguzman.scala.game.scalebra.mvc.view.View
import org.lwjgl.input.Keyboard

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.controller.schema
  * @note This class will take some action based on key events gotten from Input
  * @since 5/8/16 1:00 AM
  */
class ControlS extends SchemaControl {
  /**
    * Take some action based on the key pressed. No parameter will be passed.
    * Instead the implementing class is expected to deal with the Keyboard.*
    * methods directly.
    */
  override def action(): Unit = {
    if (!Keyboard.getEventKeyState) {
      return
    }

    /** Get Event key */
    val key = Keyboard.getEventKey

    val dir: Option[Direction] = key match {
      case Keyboard.KEY_W => Some(Up())
      case Keyboard.KEY_S => Some(Down())
      case Keyboard.KEY_L => Some(Left())
      case Keyboard.KEY_R => Some(Right())
      case Keyboard.KEY_P => {
        View.pauseToggle()
        None
      }
      case _ => None
    }

    if (dir.isDefined) {
      Model.dir = dir.get
    }
  }
}

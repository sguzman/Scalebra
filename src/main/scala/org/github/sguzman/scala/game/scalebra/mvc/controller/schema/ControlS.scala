package org.github.sguzman.scala.game.scalebra.mvc.controller.schema

import org.github.sguzman.scala.game.scalebra.Scalebra
import org.github.sguzman.scala.game.scalebra.mvc.model.{Direction, Down, Left, Right, Up}
import org.github.sguzman.scala.game.scalebra.mvc.view.pause.TogglePause
import org.github.sguzman.scala.game.scalebra.util.log.L
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
    L.i("Key event seen", "Input")
    if (!Keyboard.getEventKeyState) {
      return
    }

    /** Get Event key */
    val key = Keyboard.getEventKey

    val dir: Option[Direction] = key match {
      case Keyboard.KEY_W =>
        L.i("Up", "Input")
        Some(Up())
      case Keyboard.KEY_S =>
        L.i("Down", "Input")
        Some(Down())
      case Keyboard.KEY_L =>
        L.i("Left", "Input")
        Some(Left())
      case Keyboard.KEY_R =>
        L.i("Right", "Input")
        Some(Right())
      case Keyboard.KEY_P =>
        L.i("P", "Input")
        Scalebra.viewAc ! TogglePause
        None
      case _ => None
    }

    if (dir.isDefined) {
      Scalebra.viewAc ! dir.get
    }
  }
}

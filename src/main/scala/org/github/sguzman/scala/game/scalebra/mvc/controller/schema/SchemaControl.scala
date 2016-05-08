package org.github.sguzman.scala.game.scalebra.mvc.controller.schema

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.controller.schema
  * @note This defines what the Input class expects from the schema controller
  *       class.
  * @since 5/8/16 1:01 AM
  */
trait SchemaControl {
  /**
    * Take some action based on the key pressed.
    * @param key Keyboard pressed
    */
  def action(key: Int): Unit
}

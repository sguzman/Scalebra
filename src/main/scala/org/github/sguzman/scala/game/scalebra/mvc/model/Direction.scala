package org.github.sguzman.scala.game.scalebra.mvc.model

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model
  *
  * @note Sealed class indication direction
  *
  * @since 5/7/16 10:26 PM
  */
sealed abstract case class Direction()

case class Up()
case class Left()
case class Right()
case class Down()
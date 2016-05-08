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
sealed abstract case class Direction(val x: Int = 0) {
  /**
    * Add two direction together. If the sum of their x's are 0, return the
    * current direction. If it is not, return the new direction
    *
    * @param d Direction
    * @return Direction
    */
  def +(d: Direction): Direction = {
    if (this.x + d.x == 0) {
      this
    } else {
      d
    }
  }
}

/**
  * The value of the variable line up with the opposite direction. If you add
  * opposite sides, it will equal to 0.
  */
case class Up() extends Direction(1)
case class Left() extends Direction(-2)
case class Right() extends Direction(2)
case class Down() extends Direction(-1)
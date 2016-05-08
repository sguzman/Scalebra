package org.github.sguzman.scala.game.scalebra.mvc.model.artifact

import org.github.sguzman.scala.game.scalebra.mvc.model.util.Tool

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.artifact
  * @note This class is food :)
  * @since 5/7/16 9:52 PM
  */
case class Food() extends Entity(Food.r, Food.g, Food.b, Tool.randX, Tool.randY) {
  /**
    * Since we only ever need one class here, I might as well init it statically.
    *
    * @return Food singleton
    */
  def apply: Food = {
    Food.inst.x = Tool.randX
    Food.inst.y = Tool.randY
    Food.inst
  }
}

object Food extends Entity(Food.r, Food.g, Food.b, Tool.randX, Tool.randY) {
  /** Static colors for food */
  val r = 1.0f
  val g = 1.0f
  val b = 1.0f

  val inst = Food()
}

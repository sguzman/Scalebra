package org.github.sguzman.scala.game.scalebra.mvc.model.artifact

import org.github.sguzman.scala.game.scalebra.mvc.model.util.RandTool

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.artifact
  *
  * @note This class is food :)
  *
  * @since 5/7/16 9:52 PM
  */
case class Food() extends Entity(Food.r, Food.g, Food.b, RandTool.randX, RandTool.randY) {
  /**
    * Since we only ever need one class here, I might as well init it statically.
    *
    * @return Food singleton
    */
  def apply: Food = {
    Food.inst.x = RandTool.randX
    Food.inst.y = RandTool.randY
    Food.inst
  }
}

object Food extends Entity(Food.r, Food.g, Food.b, RandTool.randX, RandTool.randY) {
  /** Static colors for food */
  val r = 1.0f
  val g = 1.0f
  val b = 1.0f

  val inst = Food()
}

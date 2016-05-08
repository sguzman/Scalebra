package org.github.sguzman.scala.game.scalebra.mvc.model.util

import org.github.sguzman.scala.game.scalebra.mvc.view.View

import scala.util.Random

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.util
  *
  * @note This class is to help generate random values
  *
  * @since 5/7/16 9:55 PM
  */
object RandTool {
  /** Initiate random engine with current time */
  Random.setSeed(System.currentTimeMillis())

  /** Divide width by 10 */
  val ranModX = View.width / 10

  /** Divide height by 10 */
  val ranModY = View.height / 10

  /**
    * Random x-location between 0 and the width
    *
    * @return Int
    */
  def randX: Int = {
    Random.nextInt(ranModX) * 10
  }

  /**
    * Random y-location between 0 and the height
    *
    * @return Int
    */
  def randY: Int = {
    Random.nextInt(ranModY) * 10
  }
}

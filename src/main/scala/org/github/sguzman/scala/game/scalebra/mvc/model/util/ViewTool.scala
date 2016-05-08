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
object ViewTool {
  /** Initiate random engine with current time */
  Random.setSeed(System.currentTimeMillis())

  /**
    * Random x-location between 0 and the width
    *
    * @return Int
    */
  def randX: Int = {
    /** Divide width by 10 */
    Random.nextInt(View.width / 10) * 10
  }

  /**
    * Random y-location between 0 and the height
    *
    * @return Int
    */
  def randY: Int = {
    /** Divide height by 10 */
    Random.nextInt(View.height / 10) * 10
  }

  /**
    * Return middle of screen's width
    */
  def midX: Int = {
    View.width / 2
  }

  /**
    * Return middle of screen's height
    */
  def midY: Int = {
    View.height / 2
  }
}

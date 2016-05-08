package org.github.sguzman.scala.game.scalebra.mvc.model.snake

import org.github.sguzman.scala.game.scalebra.mvc.model.util.Tool
import org.github.sguzman.scala.game.scalebra.mvc.model.{Direction, Left}
import scala.collection.mutable
import scala.util.Random

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.snake
  * @note This is the actual snake body. This will consist of several SnakePiece's
  * @since 5/7/16 11:57 PM
  */
class Snake(x: Int = Tool.midX, y: Int = Tool.midY) {
  /** This is the direction the snake is moving in */
  var dir: Direction = Left()

  /**
    * This will contain all the area that the snake covers. This will be a set
    * of all the directions of the snake.
    */
  val area = mutable.HashSet.empty[(Int,Int)]

  /**
    * The snake's body will receive a different color depending on it's place. But
    * the color should not change from run to run.
    */
  val rSeed = 404
  val rand = new Random(rSeed)

  /**
    * This will list will contain the entire snake
    */
  val snake = mutable.ArrayBuffer.empty[SnakePiece]
  snake += new SnakePiece(
    rand.nextFloat(),
    rand.nextFloat(),
    rand.nextFloat(),
    x, y
  )

  /**
    * Render all snake pieces
    */
  def render(): Unit = snake foreach (_.render())

  /**
    * Trickle down the locations of each piece to each successive piece
    */
  def transferLoc(): Unit = {
    if (snake.isEmpty) {
      return
    }

    /**
      * Pass down all locations. Nice and succinct :)
      */
    snake.init map (s => (s.x, s.y)) zip snake.tail foreach {
      case ((i, j), p) => (p.x, p.y) = (i, j)
    }
  }

  /**
    * Set new direction for snake. Do not allow backtracking
    *
    * @param d Direction
    */
  def setDir(d: Direction): Unit = {
    dir.synchronized {
      dir = dir + d
    }
  }

  /**
    * Got a food event
    */
  def grow(): Unit = {
    /** It doesn't matter what x & y are. They will be set eventually. */
    snake += new SnakePiece(rand.nextFloat(), rand.nextFloat(), rand.nextFloat())
  }

  /**
    * Was there a collision?
    *
    * @param coord Coordinate
    * @return Boolean
    */
  def hit(coord: (Int, Int)): Boolean = area.contains(coord)
}

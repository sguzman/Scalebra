package org.github.sguzman.scala.game.scalebra.mvc.model.artifact.snake

import org.github.sguzman.scala.game.scalebra.mvc.model.util.ViewTool
import org.github.sguzman.scala.game.scalebra.mvc.model.{Direction, Left}
import scala.collection.mutable
import scala.util.Random

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.artifact.snake
  * @note This is the actual snake body. This will consist of several SnakePiece's
  * @since 5/7/16 11:57 PM
  */
class Snake(x: Int = ViewTool.midX, y: Int = ViewTool.midY) {
  /** This is the direction the snake is moving in */
  var dir: Direction = Left()

  /**
    * This will contain all the area that the snake covers. This will be a set
    * of all the directions of the snake.
    */
  var area = mutable.HashSet.empty[(Int,Int)]

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
    * Map the location of each snake body piece into the hash set. If the number,
    * of entries are less than the number of bodies, that means we have a intra-
    * snake collision
    */
  def areaUpdate(): Unit = {
    area.clear()

    area ++= snake map (_.coor)
  }

  /**
    * Trickle down the locations of each piece to each successive piece
    */
  private def transferLoc(): Unit = {
    if (snake.length == 1) {
      return
    }

    /**
      * Pass down all locations. Nice and succinct :)
      */
    snake.init map (_.coor) zip snake.tail foreach {
      case ((i, j), p) => p(i, j)
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
 *
    * @return Boolean
    */
  def hit(coord: (Int, Int)): Boolean = area.contains(coord)
}

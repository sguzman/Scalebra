package org.github.sguzman.scala.game.scalebra.mvc.model.artifact.snake

import org.github.sguzman.scala.game.scalebra.mvc.model.artifact.Entity

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.artifact.snake
  * @note This class holds an individual snake piece. This is a simple square.
  *       It doesn't matter what the snake piece's coordinates are since they will
  *       be overridden anyway.
  * @since 5/7/16 11:46 PM
  */
private class SnakePiece(r: Float, g: Float, b: Float, override var x: Float = 0, override var y: Float = 0)
  extends Entity(r, g, b, x, y)

package org.github.sguzman.scala.game.scalebra.mvc.model.snake

import org.github.sguzman.scala.game.scalebra.mvc.model.artifact.Entity

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.snake
  * @note This class holds an individual snake piece. This is a simple square
  * @since 5/7/16 11:46 PM
  */
private class SnakePiece(r: Float, g: Float, b: Float, override var x: Float, override var y: Float)
  extends Entity(r, g, b, x, y)

package org.github.sguzman.scala.game.scalebra.util.config

/**
  * @
  */
object Reflect {
  /**
    * Kept in case I need to increment or decrement the count
    */
  val counter = 0

  def callerAt(idx: Int) = new Exception().getStackTrace()(idx + counter)
  def thisCaller = callerAt(2)
  def prevCaller = callerAt(3)
  def pprevCaller = callerAt(4)
}

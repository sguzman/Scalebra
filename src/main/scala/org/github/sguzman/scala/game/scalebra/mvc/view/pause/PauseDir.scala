package org.github.sguzman.scala.game.scalebra.mvc.view.pause

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.view.pause
  * @note Pause directives for akka actors
  * @since 5/8/16 4:19 PM
  */
abstract sealed class PauseDir

case class Pause() extends PauseDir
case class UnPause() extends PauseDir
case class TogglePause() extends PauseDir

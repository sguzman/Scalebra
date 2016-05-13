package org.github.sguzman.scala.game.scalebra.actor

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.actor
  * @note Since I am moving to using Akka instead of threads, I will define
  *       state classes here to be used for messages
  * @since 5/8/16 2:53 AM
  */
abstract sealed class Directive()

case class Start() extends Directive
case class Stop() extends Directive

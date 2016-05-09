package org.github.sguzman.scala.game.scalebra

import akka.actor.{Actor, ActorSystem, Props}
import org.github.sguzman.scala.game.scalebra.actor.{Stop, Start}
import org.github.sguzman.scala.game.scalebra.mvc.controller.Input
import org.github.sguzman.scala.game.scalebra.mvc.view.View

/**
  * @author Salvador Guzman <guzmansalv@gmail.com>
  *
  * SCALEBRA - A Snake Clone
  *
  * Scalebra is a portmanteau of Scala and Culebra which is Spanish for snake.
  * This is a simple, basic clone of snake.
  *
  * For concurrency, this game uses Akka. I tried to set up each subsystem as
  * it's own actor. So far, there are only 2 such systems; rendering and input.
  */
object Scalebra {
  /** Akka actor system */
  val system = ActorSystem("Scalebra")

  /** Supervisor actor */
  val supervisor = system.actorOf(Props[Scalebra])
  /** View rendering actor */
  val viewAc = system.actorOf(Props[View], "View")
  /** Input handling actor */
  val inputAc = system.actorOf(Props[Input], "View")

  /**
    * Driver program for entire game
    *
    * @param args Array[String]
    */
  def main(args: Array[String]) = {
    supervisor ! Start
  }
}

class Scalebra extends Actor {
  override def receive: Receive = {
    case Start =>
      Scalebra.viewAc ! Start
      Scalebra.inputAc ! Start
    case Stop =>
      Scalebra.viewAc ! Stop
      Scalebra.inputAc ! Stop
  }
}
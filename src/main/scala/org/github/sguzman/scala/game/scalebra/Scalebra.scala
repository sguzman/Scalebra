package org.github.sguzman.scala.game.scalebra

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import org.github.sguzman.scala.game.scalebra.actor.{Start, Stop}
import org.github.sguzman.scala.game.scalebra.util.log.L
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
  val supervisor = system.actorOf(Props[Scalebra], "Root")
  /** View rendering actor */
  val viewAc = system.actorOf(Props[View], "View")
  /** Input handling actor */
  val inputAc = system.actorOf(Props[Input], "Input")

  /**
    * Driver program for entire game
    *
    * @param args Array[String]
    */
  def main(args: Array[String]) = {
    L.i("Init System", "Scalebra")
    supervisor ! Start()
    while (true) {
      //L.i("Looping", "Scalebra")
    }
  }
}

/**
  * Main actor class. This class will server as the supervisor for the actor
  * system found in this project.
  *
  * For now, all it can do is start and stop the entire system.
  */
class Scalebra extends Actor with ActorLogging {
  override def receive: Receive = {
    case _: Start =>
      L.i("Start object received... starting View actor", "Scalebra")
      Scalebra.viewAc ! Start()
    case _: Stop =>
      L.i("Stop object received... shutting it down. Shutting it all down!!!", "Scalebra")
      Scalebra.viewAc ! Stop()
  }
}
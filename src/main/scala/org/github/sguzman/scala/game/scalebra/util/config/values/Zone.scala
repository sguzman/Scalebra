package org.github.sguzman.scala.game.scalebra.util.config.values

import java.time.ZoneId

/**
  * Tracks the app's zone
  */
object Zone {
  val zone = "America/Los_Angeles"
  val zoneId = ZoneId.of(zone)
}

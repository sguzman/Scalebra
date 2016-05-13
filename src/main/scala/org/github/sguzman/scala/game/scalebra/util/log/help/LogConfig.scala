package org.github.sguzman.scala.game.scalebra.util.log.help

import com.acme.util.config.values.App

/**
  * This case class holds all config information that will be included in log
  * message. It is information that is not known until the logging actually
  * happens.
  *
  * @param name Name of the app
  * @param mode mode of the app
  * @param `class` invoking class
  * @param method invoking method
  * @param line invoking line number
  * @param context context of log
  */
case class LogConfig(
  // Name of the app is unlikely to change
  val name: Option[String] = Some(App.name),
  val mode: Option[String] = None,
  val `class`: Option[String] = None,
  val method: Option[String] = None,
  val line: Option[String] = None,
  val context: Option[String] = None,
  val custom: Option[String] = None
) {
  def tuple = Seq[(String, Option[String])](
    ("name", this.name),
    ("mode", this.mode),
    ("class", this.`class`),
    ("method", this.method),
    ("line", this.line),
    ("context", this.context),
    ("custom", this.custom)
  )
}
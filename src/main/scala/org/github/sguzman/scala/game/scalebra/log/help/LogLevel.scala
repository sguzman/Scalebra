package org.github.sguzman.scala.game.scalebra.log.help

import org.pmw.tinylog.Level

/**
  * Enumeration of log levels
  */
abstract sealed class LogLevel(val int: Int, val str: String)

/**
  * Log levels string representation, matched to their corresponding tinylog
  * level
  */
case class Ltrace() extends LogLevel(Level.TRACE.ordinal(), "TRACE")
case class Ldebug() extends LogLevel(Level.DEBUG.ordinal(), "DEBUG")
case class Linfo() extends LogLevel(Level.INFO.ordinal() ,"INFO")
case class Lwarn() extends LogLevel(Level.WARNING.ordinal() ,"WARN")
case class Lerror() extends LogLevel(Level.ERROR.ordinal() ,"ERROR")
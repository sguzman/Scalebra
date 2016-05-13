package org.github.sguzman.scala.game.scalebra.util.log.help

import org.pmw.tinylog.Logger

/**
  * Log class that handles differentiating between different levels
  */
object LogMethod {
  final def apply(level: LogLevel): LogMethod = level match {
    case _: Ltrace => Trace()
    case _: Ldebug => Debug()
    case _: Linfo => Info()
    case _: Lwarn => Warn()
    case _: Lerror => Error()
  }
}

sealed abstract class LogMethod {
  def apply(msg: String): Unit
  def apply(msg: String, any: AnyRef*): Unit
  def apply(throwMe: Throwable): Unit
  def apply(throwMe: Throwable, msg: String): Unit
  def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit
}

/**
  * Trace log level class - Print Log message as trace
  */
case class Trace() extends LogMethod {
  override def apply(msg: String): Unit =
    Logger.trace(msg)

  override def apply(msg: String, any: AnyRef*): Unit =
    Logger.trace(msg, any: _*)

  override def apply(throwMe: Throwable): Unit =
    Logger.trace(throwMe)

  override def apply(throwMe: Throwable, msg: String): Unit =
    Logger.trace(throwMe, msg)

  override def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit =
    Logger.trace(throwMe, msg, any: _*)
}

/**
  * Debug log level class - Print Log message as debug
  */
case class Debug() extends LogMethod {
  override def apply(msg: String): Unit =
    Logger.debug(msg)

  override def apply(msg: String, any: AnyRef*): Unit =
    Logger.debug(msg, any: _*)

  override def apply(throwMe: Throwable): Unit =
    Logger.debug(throwMe)

  override def apply(throwMe: Throwable, msg: String): Unit =
    Logger.debug(throwMe, msg)

  override def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit =
    Logger.debug(throwMe, msg, any: _*)
}

/**
  * Info log level class - Print Log message as info
  */
case class Info() extends LogMethod {
  override def apply(msg: String): Unit =
    Logger.info(msg)

  override def apply(msg: String, any: AnyRef*): Unit =
    Logger.info(msg, any: _*)

  override def apply(throwMe: Throwable): Unit =
    Logger.info(throwMe)

  override def apply(throwMe: Throwable, msg: String): Unit =
    Logger.info(throwMe, msg)

  override def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit =
    Logger.info(throwMe, msg, any: _*)
}

/**
  * Warn log level class - Print Log message as warn
  */
case class Warn() extends LogMethod {
  override def apply(msg: String): Unit =
    Logger.warn(msg)

  override def apply(msg: String, any: AnyRef*): Unit =
    Logger.warn(msg, any: _*)

  override def apply(throwMe: Throwable): Unit =
    Logger.warn(throwMe)

  override def apply(throwMe: Throwable, msg: String): Unit =
    Logger.warn(throwMe, msg)

  override def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit =
    Logger.warn(throwMe, msg, any: _*)
}

/**
  * Error log level class - Print Log message as error
  */
case class Error() extends LogMethod {
  override def apply(msg: String): Unit =
    Logger.error(msg)

  override def apply(msg: String, any: AnyRef*): Unit =
    Logger.error(msg, any: _*)

  override def apply(throwMe: Throwable): Unit =
    Logger.error(throwMe)

  override def apply(throwMe: Throwable, msg: String): Unit =
    Logger.error(throwMe, msg)

  override def apply(throwMe: Throwable, msg: String, any: AnyRef*): Unit =
    Logger.error(throwMe, msg, any: _*)
}
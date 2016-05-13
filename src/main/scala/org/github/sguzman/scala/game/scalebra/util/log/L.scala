package org.github.sguzman.scala.game.scalebra.util.log

import org.apache.commons.lang3.StringUtils
import org.github.sguzman.scala.game.scalebra.util.config.Reflect
import org.github.sguzman.scala.game.scalebra.util.config.values.{Locale, Log, App}
import org.github.sguzman.scala.game.scalebra.util.log.help.{Ldebug, Ltrace, LogMethod, LogLevel, LogConfig, Linfo, Lerror, Lwarn}
import org.pmw.tinylog.{Configurator, LoggingContext}

/**
  * This is a tiny (get it?) wrapper around TinyLog. This accomplishes two things,
  *
  * 1. - It abbreviates the API for logging. While this wasn't the intention I
  * started with, it sure is nice to type 1-character long functions :)
  *
  * 2. - It customizes the logging message to something more workable
  */
object L {

  /**
    * The values that will be set into the logging context will be grabbed from
    * this object.
    *
    * Only name, mode, and custom will be accessible here for the user.
    */
  object Lc {
    var name: Option[String] = Some(App.name)
    var mode: Option[String] = Some(Log.mode)
    var custom: Option[String] = Some(Log.custom)

    def config(stackEle: StackTraceElement, context: String): LogConfig =
      LogConfig(name, mode, Some(StringUtils.substringAfterLast(stackEle.getClassName, ".")),
        Some(stackEle.getMethodName), Some(stackEle.getLineNumber.toString),
        Some(context), custom)

    def config(context: String): LogConfig =
      config(Reflect.pprevCaller, context)
  }
  /**
    * Disable default log pattern of tinylog and use `msg`
    */
  Configurator.currentConfig()
    .formatPattern(Log.msg)
    .level(Log.level)
    .locale(Locale.locale)
    .activate()

  /**
    * Update Logging Context from LogConfig class
    *
    * @param config collection of context config values
    */
  def cont(config: LogConfig): Unit =
    for(
      // Skip None's
      (opt, Some(value)) <- config.tuple
    ) LoggingContext.put(opt, value)

  /**
    * Logging backend method. Sets up the logging contexts variables and then
    * makes the call to the proper logging level based on the level and args
    *
    * @param level Log level
    * @param config Config for Logging Context
    * @param msg Logging message
    */
  def l(level: LogLevel, config: LogConfig, msg: String): Unit = {
    cont(config)
    LogMethod(level)(msg)
  }

  /**
    * Logging backend method. Sets up the logging contexts variables and then
    * makes the call to the proper logging level based on the level and args
    *
    * @param level Log level
    * @param config Config for Logging Context
    * @param msg throwable message
    */
  def l(level: LogLevel, config: LogConfig, msg: String, args: AnyRef*): Unit = {
    cont(config)
    LogMethod(level)(msg, args: _*)
  }

  /**
    * Logging backend method. Sets up the logging contexts variables and then
    * makes the call to the proper logging level based on the level and args
    *
    * @param level Log level
    * @param config Config for Logging Context
    * @param throwMe throwable message
    */
  def l(level: LogLevel, config: LogConfig, throwMe: Throwable): Unit = {
    cont(config)
    LogMethod(level)(throwMe)
  }

  /**
    * Logging backend method. Sets up the logging contexts variables and then
    * makes the call to the proper logging level based on the level and args
    *
    * @param level Log level
    * @param config Config for Logging Context
    * @param throwMe throwable message
    */
  def l(level: LogLevel, config: LogConfig, throwMe: Throwable, msg: String) = {
    cont(config)
    LogMethod(level)(throwMe, msg)
  }

  /**
    * Logging backend method. Sets up the logging contexts variables and then
    * makes the call to the proper logging level based on the level and args
    *
    * @param level Log level
    * @param config Config for Logging Context
    * @param throwMe throwable message
    */
  def l(level: LogLevel, config: LogConfig, throwMe: Throwable, msg: String, any: AnyRef*): Unit = {
    cont(config)
    LogMethod(level)(throwMe, msg, any: _*)
  }

  def t(msg: String, context: String): Unit =
    l(Ltrace(), Lc.config(context), msg)

  def t(msg: String, context: String, any: AnyRef*): Unit =
    l(Ltrace(), Lc.config(context), msg, any: _*)

  def t(throwMe: Throwable, context: String): Unit =
    l(Ltrace(), Lc.config(context), throwMe)

  def t(throwMe: Throwable, msg: String, context: String): Unit =
    l(Ltrace(), Lc.config(context), throwMe, msg)

  def t(throwMe: Throwable, msg: String, context: String, any: AnyRef*): Unit =
    l(Ltrace(), Lc.config(context), throwMe, msg, any: _*)

  def d(msg: String, context: String): Unit =
    l(Ldebug(), Lc.config(context), msg)

  def d(msg: String, context: String, any: AnyRef*): Unit =
    l(Ldebug(), Lc.config(context), msg, any: _*)

  def d(throwMe: Throwable, context: String): Unit =
    l(Ldebug(), Lc.config(context), throwMe)

  def d(throwMe: Throwable, msg: String, context: String): Unit =
    l(Ldebug(), Lc.config(context), throwMe, msg)

  def d(throwMe: Throwable, msg: String, context: String, any: AnyRef*): Unit =
    l(Ldebug(), Lc.config(context), throwMe, msg, any: _*)

  def i(msg: String, context: String): Unit =
    l(Linfo(), Lc.config(context), msg)

  def i(msg: String, context: String, any: AnyRef*): Unit =
    l(Linfo(), Lc.config(context), msg, any: _*)

  def i(throwMe: Throwable, context: String): Unit =
    l(Linfo(), Lc.config(context), throwMe)

  def i(throwMe: Throwable, msg: String, context: String): Unit =
    l(Linfo(), Lc.config(context), throwMe, msg)

  def i(throwMe: Throwable, msg: String, context: String, any: AnyRef*): Unit =
    l(Linfo(), Lc.config(context), throwMe, msg, any: _*)

  def w(msg: String, context: String): Unit =
    l(Lwarn(), Lc.config(context), msg)

  def w(msg: String, context: String, any: AnyRef*): Unit =
    l(Lwarn(), Lc.config(context), msg, any: _*)

  def w(throwMe: Throwable, context: String): Unit =
    l(Lwarn(), Lc.config(context), throwMe)

  def w(throwMe: Throwable, msg: String, context: String): Unit =
    l(Lwarn(), Lc.config(context), throwMe, msg)

  def w(throwMe: Throwable, msg: String, context: String, any: AnyRef*): Unit =
    l(Lwarn(), Lc.config(context), throwMe, msg, any: _*)

  def e(msg: String, context: String): Unit =
    l(Lerror(), Lc.config(context), msg)

  def e(msg: String, context: String, any: AnyRef*): Unit =
    l(Lerror(), Lc.config(context), msg, any: _*)

  def e(throwMe: Throwable, context: String): Unit =
    l(Lerror(), Lc.config(context), throwMe)

  def e(throwMe: Throwable, msg: String, context: String): Unit =
    l(Lerror(), Lc.config(context), throwMe, msg)

  def e(throwMe: Throwable, msg: String, context: String, any: AnyRef*): Unit =
    l(Lerror(), Lc.config(context), throwMe, msg, any: _*)
}

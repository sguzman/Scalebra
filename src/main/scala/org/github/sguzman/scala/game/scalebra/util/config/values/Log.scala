package org.github.sguzman.scala.game.scalebra.util.config.values

import org.pmw.tinylog.Level

/**
  * Created by sguzman on 3/26/16.
  */
object Log {
  val level = Level.DEBUG
  val mode = "normal"
  val custom = ""

  /**
    * This will be the pattern format for the log message. I specified as much as
    * I could in the string. Everything else will be set using
    *
    * 1st - date
    *
    * 2nd - pid of app
    *
    * 3rd - log level
    *
    * 4th - name of app
    * 5th - name of current thread
    * 6th - mode that the app is currently in
    * 7th - any custom message you may add
    *
    * 8th - name of the invoking class
    * 9th - name of the invoking method
    * 10th - line number
    *
    * 11th - log message
    * 12th - log context
    */
  val msg = "[{date:MM-dd yyyy HH:mm:ss.SSS z}] [{pid}] [{level}] " +
    "[{context:name}:{thread}:{context:mode}:{context:custom}] " +
    "[{context:class}.{context:method}:{context:line}] ({message}) " +
    "CONTEXT=[{context:context}]"
}

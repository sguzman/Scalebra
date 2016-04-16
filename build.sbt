/** Name of project */
name := "Scalebra"

/** Project Version */
version := "1.0"

/** Scala version */
scalaVersion := "2.11.8"

/** Scalac parameters */
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

/** Javac parameters */
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

/** Resolver */
resolvers += "Search Maven" at "https://repo1.maven.org/maven2/"

/** Source Dependencies */
libraryDependencies ++= Seq(
  "org.lwjgl.lwjgl" % "lwjgl_util"    % "2.9.3",
  "org.slick2d"     % "slick2d-core"  % "1.0.1"
)

/** Make sure to fork on run */
fork in run := true

/** Add resources to java library path */
javaOptions in run += "-Djava.library.path=src/main/resources"
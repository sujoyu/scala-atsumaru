enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"
scalaVersion := "2.12.2"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

jsDependencies += "org.webjars.bower" % "EaselJS" % "1.0.2" / "lib/easeljs-1.0.2.min.js"

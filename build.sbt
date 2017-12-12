enablePlugins(ScalaJSPlugin)

name := "Scala Atsumaru Tutorial"
scalaVersion := "2.12.2"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

skip in packageJSDependencies := false
jsDependencies += "org.webjars.bower" % "EaselJS" % "1.0.2" / "lib/easeljs.min.js"

scalaJSUseMainModuleInitializer := true

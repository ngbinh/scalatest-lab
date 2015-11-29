/*
 * Copyright (C) 2014 Anduin Transaction Inc.
*/

import java.io.File
import com.typesafe.sbt.web.SbtWeb
import org.scalajs.sbtplugin.cross.{CrossProject, CrossType}

import sbt._

object Versions {
  scala = "2.11.7"
  scalatest = "3.0.0-M12"
}

object ScalaTestExampleBuild extends Build {

  lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
    .settings(
      scalaVersion := Versions.scala,
      libraryDependencies ++=  Seq(
        "org.scala-lang" % "scala-reflect" % Versions.scala % "provided",
        "org.scala-lang" % "scala-compiler" % Versions.scala % "provided",
        "org.scalatest"  %%% "scalatest" % Versions.scalatest % Test
      )
    )
    // set up settings specific to the JS project
    .jsConfigure(_ enablePlugins ScalaJSPlugin)

  lazy val js = root.js
  lazy val jvm= root.jvm
}

import sbt._
import Keys._

lazy val slearn = (project in file(".")).
  settings(
    name := "slearn",
    version := "0.0.1",
    scalaVersion := "2.11.8",

    // Depenency
    libraryDependencies ++= Seq(
      // "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.reflections" % "reflections" % "0.9.9-RC1",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    ),

    // Compilation
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-feature",
      "-encoding", "UTF-8",
      "-Xlint",
      "-Xlint:-missing-interpolator",
      "-Ywarn-unused",
      "-Ywarn-value-discard"
    )
  )

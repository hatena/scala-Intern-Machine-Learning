import sbt._
import Keys._

lazy val internml = (project in file(".")).
  settings(
    name := "internml",
    version := "0.0.1",
    scalaVersion := "2.11.8",

    // Depenency
    libraryDependencies ++= Seq(
      "org.reflections" % "reflections" % "0.9.9-RC1"
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

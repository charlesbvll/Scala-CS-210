package ch.epfl.lamp

import sbt._
import sbt.Keys._

/**
  * Settings shared by all assignments, reused in various tasks.
  */
object MOOCSettings extends AutoPlugin {

  object autoImport {
    val course = SettingKey[String]("course")
    val assignment = SettingKey[String]("assignment")
    val testSuite = SettingKey[String]("testSuite")
    val options = SettingKey[Map[String, Map[String, String]]]("options")
  }

  override def trigger = allRequirements

  override val projectSettings: Seq[Def.Setting[_]] = Seq(
    parallelExecution in Test := false
  )
}

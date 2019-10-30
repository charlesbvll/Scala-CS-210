course := "progfun2"
assignment := "streams"
name := course.value + "-" + assignment.value
testSuite := "streams.BloxorzSuite"

scalaVersion := "0.19.0-RC1"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
libraryDependencies += ("org.scalacheck" %% "scalacheck" % "1.14.2").withDottyCompat(scalaVersion.value)

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

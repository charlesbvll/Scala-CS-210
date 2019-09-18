course := "progfun1"
assignment := "recfun"
name := course.value + "-" + assignment.value
testSuite := "recfun.RecFunSuite"

scalaVersion := "0.19.0-bin-20190918-dd68eb8-NIGHTLY"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

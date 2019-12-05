course := "progfun2"
assignment := "newInterpreter"
name := course.value + "-" + assignment.value
testSuite := "newInterpreter.RecursiveLanguageSuite"

scalaVersion := "0.19.0-RC1"
scalacOptions ++= Seq("-deprecation")
libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % Test
)

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

course := "progfun1"
assignment := "example"
name := course.value + "-" + assignment.value
testSuite := "example.ListsSuite"
scalaVersion := "0.19.0-bin-20190917-d821081-NIGHTLY"
scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

course := "progfun2"
assignment := "codecs"
name := course.value + "-" + assignment.value
testSuite := "codecs.CodecsSuite"

scalaVersion := "0.19.0-RC1"
scalacOptions ++= Seq("-deprecation")
libraryDependencies ++= Seq(
  ("org.scalacheck" %% "scalacheck" % "1.14.2" % Test).withDottyCompat(scalaVersion.value),
  ("org.typelevel" %% "jawn-parser" % "0.14.2").withDottyCompat(scalaVersion.value),
  "com.novocode" % "junit-interface" % "0.11" % Test
)

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

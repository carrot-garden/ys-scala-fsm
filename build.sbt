import sbt.Keys.scalacOptions

lazy val root = (project in file(".")).
  settings(
    name := "ys-scala-fsm",
    version := "0.1.0",
    scalaVersion := "2.12.1",
	libraryDependencies ++= {
		val scalacticVersion = "3.0.0"
		val scalatestVersion = "3.0.0"
		Seq(
			"org.scalatest" %% "scalatest" % scalatestVersion % "test"
    )
	},
    scalacOptions in (Compile, doc) ++= Seq("-author"),
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"),
    packAutoSettings
)
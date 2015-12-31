lazy val root = (project in file(".")).
  settings(
    name := "ys-scala-fsm",
    version := "0.0.0",
    scalaVersion := "2.11.7",
	    libraryDependencies ++= Seq(
    	"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    	"com.novocode" % "junit-interface" % "0.11" % Test
    ),
    scalacOptions in (Compile, doc) ++= Seq("-author"),
    packAutoSettings
)
// *****************************************************************************
// Projects
// *****************************************************************************

lazy val root =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.zio,
        library.zioConfig,
        library.zioTest % Test,
        library.zioTestSbt % Test
      ),
      testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {

    object Version {
      val zio = "1.0.0-RC18-2"
      val zioConfig = "1.0.0-RC16-1"
    }

    val zio = "dev.zio" %% "zio" % Version.zio
    val zioTest = "dev.zio" %% "zio-test" % Version.zio
    val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Version.zio

    val zioConfig = "dev.zio" %% "zio-config" % Version.zioConfig
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
    scalafmtSettings ++
    commandAliases

lazy val commonSettings =
  Seq(
    name := "$name$",
    scalaVersion := "2.13.1",
    organization := "com.example"
  )

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true
  )

lazy val commandAliases =
  addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt") ++
    addCommandAlias("check", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.2"

val scalikejdbcVersion = "3.4.2"

//libraryDependencies ++= Seq(
//  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % "test"
//)


libraryDependencies ++= Seq(
  guice,
  jdbc,
  evolutions,
  "com.h2database"         %  "h2"                           % "1.4.200",
  "org.scalikejdbc"        %% "scalikejdbc"                  % scalikejdbcVersion,
  "org.scalikejdbc"        %% "scalikejdbc-config"           % scalikejdbcVersion,
  "org.scalikejdbc"        %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.4",
  "org.scalatestplus.play" %% "scalatestplus-play"           % "5.0.0" % Test
)

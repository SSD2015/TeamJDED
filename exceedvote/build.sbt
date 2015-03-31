organization := "com.feth"

name := """exceedvote"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.feth" %% "play-authenticate" % "0.6.8",
  "mysql" % "mysql-connector-java" % "5.1.21",
  "org.xerial" % "sqlite-jdbc" % "3.7.2",
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)


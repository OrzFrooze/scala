name := "demo"

version := "0.1"

scalaVersion := "2.13.5"

//libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.21"
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.21",
  "com.typesafe.akka" %% "akka-actor" % "2.6.8",
  "net.liftweb" %% "lift-json" % "3.4.2"
)
exportJars := true

//resolvers += "Local Maven Repository" at "file://E://repository"
resolvers ++= Seq( //额外仓库添加
  "Admonitor Repository" at "http://maven.mzsvn.com/repository/admonitor",
  "Local Maven Repository" at "file://E://repository"
)
name := "demo"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.21"

exportJars :=true

resolvers += "Local Maven Repository" at "file://E://repository"
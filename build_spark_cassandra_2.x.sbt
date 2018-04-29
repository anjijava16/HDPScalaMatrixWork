name := """WEB-spark-streaming-cassandra-project-2.x"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.apache.spark"  %% "spark-core"  % "2.0.2" % "provided",
  "org.apache.spark"  %% "spark-streaming" % "2.0.2",
  "org.apache.spark"  %% "spark-streaming-kafka" % "1.6.0",
  "org.apache.spark"  %% "spark-streaming-flume" % "2.0.2",
  "org.apache.spark"  %% "spark-sql" % "2.0.2",
  "org.apache.spark"  %% "spark-mllib" % "2.0.2",
  "com.typesafe.akka" %% "akka-actor"  % "2.3.13", 
  "com.typesafe.akka" %% "akka-slf4j"  % "2.3.13"
)

dependencyOverrides ++= Set( 
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4" 
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"
libraryDependencies += "com.typesafe.play" %% "anorm" % "2.4.0"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.4"
libraryDependencies += "com.google.code.gson" % "gson" % "2.6.2"
libraryDependencies += "net.liftweb" % "lift-json_2.11" % "2.6"
libraryDependencies += "com.google.guava" % "guava" % "17.0"

// cassandra integration
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.2"
libraryDependencies += "com.datastax.spark" % "spark-cassandra-connector_2.11" % "2.0.0-M3"
libraryDependencies += "com.twitter" % "jsr166e" % "1.1.0"
libraryDependencies += "org.apache.cassandra" % "cassandra-all" % "3.5"
libraryDependencies += "org.mortbay.jetty" % "servlet-api" % "3.0.20100224"


resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Twitter4J Repository" at "http://twitter4j.org/maven2/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
  Resolver.sonatypeRepo("public")
)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

EclipseKeys.preTasks := Seq(compile in Compile)

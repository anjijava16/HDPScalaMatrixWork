name := "KalyanSparkTrainingProjectSbt-2.x"

version := "1.0"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

unmanagedSourceDirectories in Compile += baseDirectory.value / "src/main/python"
unmanagedSourceDirectories in Compile += baseDirectory.value / "src/main/resources"
unmanagedSourceDirectories in Compile += baseDirectory.value / "src/test/scala"

// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.0.2" % "provided",
  "org.apache.spark" %% "spark-sql" % "2.0.2",
  "org.apache.spark" %% "spark-hive" % "2.0.2",
  "org.apache.spark" %% "spark-streaming" % "2.0.2",
  "org.apache.spark" %% "spark-streaming-mqtt" % "1.6.0",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0",
  "org.apache.spark" %% "spark-streaming-flume" % "2.0.2",
  "org.apache.spark" %% "spark-streaming-twitter" % "1.6.0",
  "org.apache.spark" %% "spark-streaming-zeromq" % "1.6.0",
  "org.apache.spark" %% "spark-mllib" % "2.0.2",
  "org.apache.spark" %% "spark-catalyst" % "2.0.2",
  "org.apache.spark" %% "spark-graphx" % "2.0.2",
  "org.apache.spark" %% "spark-repl" % "2.0.2",
  "org.apache.spark" %% "spark-unsafe" % "2.0.2",
  "org.apache.spark" %% "spark-yarn" % "2.0.2",
  "org.apache.spark" %% "spark-test-tags" % "1.6.0",
  "org.apache.commons" % "commons-lang3" % "3.0",
  
  "org.apache.cassandra" % "apache-cassandra" % "1.2.0",
  "org.apache.cassandra" % "cassandra-all" % "1.2.0",
  "org.apache.cassandra" % "cassandra-thrift" % "1.2.0",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.5.0-M3",
  "com.datastax.spark" %% "spark-cassandra-connector-java" % "1.5.0-M3",
  
  "org.eclipse.jetty"  % "jetty-client" % "8.1.14.v20131031",
  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.0.2",
  "com.typesafe.play" % "play-json_2.11" % "2.5.0-M1" exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.4.4",
  "org.elasticsearch" % "elasticsearch-hadoop-mr" % "2.0.0.RC1",
  "net.sf.opencsv" % "opencsv" % "2.0",
  
  "com.twitter.elephantbird" % "elephant-bird" % "4.12",
  "com.twitter.elephantbird" % "elephant-bird-core" % "4.12",
  "com.twitter" %% "algebird-core" % "0.11.0",
  "com.hadoop.gplcompression" % "hadoop-lzo" % "0.4.17",
  "mysql" % "mysql-connector-java" % "5.1.31",
  "com.github.scopt" %% "scopt" % "3.3.0",
  
  "org.apache.hadoop" % "hadoop-common" % "2.6.0",
  "org.apache.hadoop" % "hadoop-streaming" % "2.6.0",
  "org.apache.hbase" % "hbase-client" % "1.1.1",
  "org.apache.hbase" % "hbase-common" % "1.1.1",
  "org.apache.hbase" % "hbase-server" % "1.1.1",
  "org.apache.hbase" % "hbase" % "1.1.1",
  "io.github.nicolasstucki" % "multisets_2.11" % "0.3",
  
  "org.apache.mahout" % "mahout" % "0.9",
  "org.apache.mahout" % "mahout-core" % "0.9",
  "org.apache.mahout" % "mahout-examples" % "0.9",
  "org.apache.mahout" % "mahout-math" % "0.9",
  "org.apache.mahout" % "mahout-integration" % "0.9"
)

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


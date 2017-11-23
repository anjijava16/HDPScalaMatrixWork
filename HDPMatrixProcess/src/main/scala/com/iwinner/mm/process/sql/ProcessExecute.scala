package com.iwinner.mm.process.sql

import org.apache.spark.sql.SparkSession

object ProcessExecute {
  
  
  def main(args: Array[String]): Unit = {
    
    
    val session = SparkSession.builder().master("local[*]").appName("Spark Hive Example").getOrCreate();

    val df=session.read.csv("/home/hadoop/applications/countries.csv");
    
    df.printSchema();
    df.show(100)
    
    
  }
}
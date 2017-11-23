package com.iwinner.mm.process

import org.apache.spark.sql.SparkSession

object SparkContextUtils {

  def init(): SparkSession = {

    val session = SparkSession.builder().appName("Spark Hive Example").enableHiveSupport().getOrCreate();

    
    return session;
  }
}
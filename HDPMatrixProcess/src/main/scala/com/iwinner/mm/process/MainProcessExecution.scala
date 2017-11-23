package com.iwinner.mm.process

import com.iwinner.mm.utils.ApplicationUtils

object MainProcessExecution {

  def execute(args:Array[String]): Unit = {

    val spark = SparkContextUtils.init();
    val database = args(0);
    val fileName = args(1);
    spark.sql(s"use $database");
    spark.sql("SET hive.exec.dynamic.partition = true")
    spark.sql("SET hive.exec.dynamic.partition.mode = nonstrict ")
    spark.sql("SET hive.exec.max.dynamic.partitions.pernode = 400")


    

    val countriesDF = spark.sql(s"select * from $database.countries")

    countriesDF.createOrReplaceTempView("countriesID");

    countriesDF.count();

    var incre = ApplicationUtils.readFileToString(fileName);
    
    for (a <- 1l to countriesDF.count()) {
       incre = ApplicationUtils.addLeadingZeros(7, incre);
       val insertQuery = s"INSERT overwrite table $database.countries_new partition(ts) SELECT code,name,continent,region,surface_area,indep_year,local_name,gov_form,capital,cap_long,cap_lat,$incre,from_unixtime(unix_timestamp(),'yyyyMMddHHmm') as ts from countriesID";
       spark.sql(insertQuery);
    }
    println("Final Increment Value is " + incre);
    ApplicationUtils.writeInputFile(fileName, incre);
    
    
  }
}
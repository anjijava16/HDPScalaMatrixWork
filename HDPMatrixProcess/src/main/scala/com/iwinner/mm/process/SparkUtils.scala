package com.iwinner.mm.process

import org.apache.spark.sql.SparkSession
import java.util.Arrays

object SparkUtils {

  def main(args: Array[String]): Unit = {

    parse(args);
    val database = args(0);
    val incrementFile = args(1);
    val run_id = args(2);
    val data_date = args(3);

    println("DataBase name is===>> " + database);
    println("IncremntFile==" + incrementFile);
    println("run_id==" + run_id);
    println("data_date==" + data_date);

    println("Start of the Utils class ");
    val spark = SparkSession.builder().appName("Spark Hive Example").enableHiveSupport().getOrCreate();

    
    //.config("spark.sql.warehouse.dir", warehouseLocation)
    /*   val df = spark.sql("show databases");
    df.show()
    df.printSchema();
*/
    //    println(" Done Show databases ");

    val countriesDF = spark.sql(s"select * from $database.countries")
    countriesDF.createOrReplaceTempView("countriesID");

    
   val insertQuery=s" INSERT overwrite $database.countries_new(ts) SELECT code,name,continent,region,surface_area,indep_year,local_name,gov_form,capital,cap_long,cap_lat,dynamic_id from countriesID";

    val df1= spark.sql("select * from countriesID");
    df1.printSchema();
    df1.show(100);
    println("End of the Utils class ");

  }

  def parse(args: Array[String]): Unit = {

    if (args.length != 4) {
      println("Wrong number if arguments"+args.length);
      System.exit(0);
      throw new Exception("Wrong number of arguments");
    }
    val database = args(0);
    val incrementFile = args(1);
    val run_id = args(2);
    val data_date = args(3);

  }

}
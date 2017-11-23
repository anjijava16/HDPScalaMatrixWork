package com.iwinner.mm.main

import com.iwinner.mm.process.SparkContextUtils
import com.iwinner.mm.process.MainProcessExecution

object Main {
 
  
  def main(args: Array[String]): Unit = {
    
    parse(args);
    MainProcessExecution.execute(args);

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
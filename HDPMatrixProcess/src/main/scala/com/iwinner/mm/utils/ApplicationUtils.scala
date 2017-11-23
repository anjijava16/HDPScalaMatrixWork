package com.iwinner.mm.utils

import scala.io.Source
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.FileWriter

object ApplicationUtils {

  def addLeadingZeros(size: Int, value: String): String = {
    val str: String = value.replaceAll("^0+(?=\\d+$)", "");
    var incrValue = str.toLong;
    incrValue = incrValue + 1;
    return String.format("%0" + size + "d", incrValue.asInstanceOf[AnyRef]);
  }

  def readFileToString(inputFileName: String): String = {
    val source = Source.fromFile(new File(inputFileName));
    val inputIncrementValue = source.getLines().mkString;
    return inputIncrementValue;
  }

  def writeInputFile(inputFileName: String, incrementValue: String): Unit = {

    val fw = new FileWriter(inputFileName, false);
    try {
      fw.write(incrementValue);
    } finally fw.close()

  }
  def main(args: Array[String]): Unit = {

    val str = "/home/hadoop/Desktop/input.txt";

    var incre = readFileToString(str);

    for (a <- 1 to 10) {
      incre = addLeadingZeros(7, incre);
      println("incre=>" + incre);
    }
    println("Final Increment Value is " + incre);
    
    writeInputFile(str,incre);
    

  }
}
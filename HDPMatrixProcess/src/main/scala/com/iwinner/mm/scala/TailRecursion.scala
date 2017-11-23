package com.iwinner.mm.scala

import scala.annotation.tailrec

object TailRecursion {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    println(product(List(1, 2, 3, 4)))
    println(product2(List(1, 2, 3, 4)))

    // (1) basic recursion; yields a "java.lang.StackOverflowError" with large lists
    def product(ints: List[Int]): Int = ints match {
      case Nil => 1
      case x :: tail => x * product(tail)
    }

    // (2) tail-recursive solution
    def product2(ints: List[Int]): Int = {
      @tailrec
      def productAccumulator(ints: List[Int], accum: Int): Int = {
        ints match {
          case Nil => accum
          case x :: tail => productAccumulator(tail, accum * x)
        }
      }
      productAccumulator(ints, 1)
    }
  }
}
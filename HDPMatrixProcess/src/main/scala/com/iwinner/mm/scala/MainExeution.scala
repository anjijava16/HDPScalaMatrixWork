package com.iwinner.mm.scala

import com.iwinner.mm.scala
/**
 * head​ - Returns the first element of a list.
 *
 * tail​ - Returns a new list with all elements of the original list except the first.
 * cons​ ​-​ ​Takes an argument and prepends it to the list.
 * drop​ - Takes an integer ‘n’ as argument and returns a new list after removing first n elements
 * from the list.
 * reverse​ - Returns the reverse of a list
 */

object MainExeution {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 56, 10, 4);

    // Way 1: Reverse Operation
    val reverseListWay1 = list.reverse;
    println("reverseListWay1 ==>>" + reverseListWay1);

    // Way 2 : Reverse Operation with recursion Approach 
    val reverseListWay2 = reverse(list);
    println("reverseListWay2 ==>> " + reverseListWay2);

    // Way 1: Filter Operation 
    val filterListWay1 = list.filter(x => x > 30)
    println("filterList ==" + filterListWay1);

    // Way 2: Filter Operation with recursion Approach
    val filterListWay2 = filter(isCheckng, list)
    println("filterListWay2 ==" + filterListWay2);

    // Way 1: Map Operation
    val mapListWay1 = list.map(x => x)
    println("mapListWay1 ==" + mapListWay1);

    // Way 2: Map Operation
    val mapListWay2 = avg(list)
    println("mapListWay2 ==" + mapListWay2);

    // Way 1 Tail Operation 
    val tailRes = list.tail;
    println("tailListWay1 ==" + tailRes);

    // Way 2 Tail Operation recursion Approach finding total elements in the list
    val tailRecuriseTotalElements = tailRecursiveSum(list);
    println("tailListWay2 ==" + tailRecuriseTotalElements);

    // Way 1 headRes Operation 
    val headRes = list.head;
    println("headResWay1 ==" + headRes);

    // Way 1 dropRes Operation
    val dropRes = list.drop(2);
    println("dropRes ==" + dropRes);

  }

  def sumOfTail(ints: List[Int]): Int = ints match {
    case Nil => 1
    case x :: tail => x * sumOfTail(tail)
  }

  def avg(nums: List[Int]): Double = {
    if (nums.length == 0) throw new Exception("length = 0")
    var sum = 0;
    for (i <- nums) sum += i
    sum / nums.length
  }

  def isCheckng(x: Int) = x > 30;

  def reverse[A](l: List[A]): List[A] = l match {
    case h :: tail => reverse(tail) ::: List(h)
    case Nil => Nil
  }

  def tailRecursiveSum(nums: List[Int]): Int = {
    def helper(result: Int, unseen: List[Int]): Int = {
      if (unseen == Nil) result else helper(unseen.head, unseen.tail)
    }
    helper(0, nums)
  }

  def reverse1(n: List[Int]): List[Int] = {
    var a = n
    var b: List[Int] = List()
    while (a.length != 0) {
      b = a.head :: b
      a = a.tail
    }
    b
  }

  def filter[T](pred: T => Boolean, vals: List[T]): List[T] = {
    if (vals == Nil) Nil
    else if (pred(vals.head)) vals.head :: filter(pred, vals.tail)
    else filter(pred, vals.tail)
  }

  def get[T](pos: Int, vals: List[T]): T = {
    if (vals == Nil) throw new Exception("List is too short");
    if (pos < 0) throw new Exception("position must not be negative");
    if (pos == 0) vals.head else get(pos - 1, vals.tail)
  }

}
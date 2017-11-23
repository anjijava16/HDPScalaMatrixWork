package com.iwinner.mm.scala



object MapWOrks {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5,6);

    
    
    val res = list.map(x => f(x));
    println(res);
    
    
    println("Tail INFO"+list.tail);
    val tailRecursion=tailRecursiveSum(list);
    println("TailRecursion INFO "+tailRecursion);
    
    
  }

  def f(x: Int): Int = {
    val res = x + 1;
    return res;
  }
  
   def tailRecursiveSum(nums: List[Int]): Int = {
    def helper(result: Int, unseen: List[Int]): Int = {
       if (unseen == Nil) result else helper(unseen.head, unseen.tail)
    }
    helper(0, nums)
}
}
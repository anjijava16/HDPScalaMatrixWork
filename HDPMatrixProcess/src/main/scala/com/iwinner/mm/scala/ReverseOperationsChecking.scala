package com.iwinner.mm.scala


class ReverseOperationsChecking {
  
  
  
def reverse(n: List[Int]): List[Int] = {
  var a = n
  var b: List[Int] = List()
  while (a.length != 0) {
    b = a.head :: b
    a = a.tail
  }
  b
}
}
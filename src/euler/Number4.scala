package euler

import scala.annotation.tailrec
import scala.collection.mutable

object Number4 {

  def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in)
      var t = sc.nextInt()
      var a0 = 0
    var map: mutable.SortedMap[Int, (Int, Int)] = mutable.TreeMap[Int, (Int, Int)]()
    (100 to 999).foreach(n1 => {
      (100 to 999).foreach(n2 => {
        if(isPalindrome(0, s"${n1*n2}")) {
          map = map + (n1*n2->(n1, n2))
        }
      })
    })
    while(a0 < t){
      var n = sc.nextInt()
      a0+=1
      println(map.filter(_._1<n).lastOption.get._1)
    }
  }

  @tailrec
  def isPalindrome(index: Int, number: String): Boolean = {
    if(index>number.length/2) {
      true
    } else if(!number.charAt(index).equals(number.charAt(number.length-1-index))) {
      false
    } else {
      isPalindrome(index + 1, number)
    }
  }

}
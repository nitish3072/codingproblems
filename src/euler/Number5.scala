package euler

import scala.collection.immutable

object Number5 {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    var t = sc.nextInt()
    var a0 = 0
    while(a0 < t){
      var n = sc.nextInt()
      a0+=1
      val primeNumbers: Seq[Int] = findPrimeNumbersBetween(2, n)
      println(primeNumbers.product)
    }
  }

  def findPrimeNumbersBetween(number1: Int, number2: Int): immutable.Seq[Int] = {
    (number1 to number2).filter(isNumberPrime)
  }

  def isNumberPrime(number: Int): Boolean = {
    val size = (2 to math.sqrt(number.toDouble).toInt).count(n => (number.toDouble / n) == number / n)
    size==0
  }

}

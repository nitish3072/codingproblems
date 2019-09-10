import java.io._

object KadanesAlgo {

  // Complete the maxSubarray function below.
  def maxSubarray(arr: Seq[Int]): Seq[Int] = {
    val allNegative = arr.map(_ < 0).forall(identity)
    if(allNegative) {
      Seq(arr.max, arr.max)
    } else {
      Seq(subArraySum(arr), subSequenceSum(arr))
    }
  }

  def subArraySum(arr: Seq[Int]): Int = {
    var i = 0
    var j = 0
    var maxSum = arr.head
    var currentSum = arr.head
    while (j+1<arr.length) {
      if(arr(i)<0 && i!=j) {
        currentSum = currentSum + arr(i)
        i = i + 1
      } else if(arr(i)<0 && i==j) {
        currentSum = arr(j+1)
        j = j + 1
        i = j
      }
      else if(arr(j+1) < 0 && currentSum + arr(j+1) < 0) {
        j = j + 1
        i = j
        currentSum = arr(j)
      } else if(arr(j+1) < 0) {
        currentSum = currentSum + arr(j+1)
        j = j + 1
      } else if(arr(j+1) < 0 && currentSum<arr(j + 1)) {
        j = j + 1
        i = j
        currentSum = arr(j)
      } else {
        currentSum = currentSum + arr(j+1)
        j = j + 1
      }
      if(currentSum>maxSum) {
        maxSum = currentSum
      }
    }
    maxSum
  }

  def subSequenceSum(arr: Seq[Int]): Int = {
    arr.filter(_>0).sum
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    var t = sc.nextInt()
    var a0 = 0
    while(a0 < t) {
      sc.nextInt()
      sc.nextLine()
      println(maxSubarray(sc.nextLine().split(" ").map(_.toInt)))
      a0= a0 + 1
    }
  }
}

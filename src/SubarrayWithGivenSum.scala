/**
  * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
  */


object SubarrayWithGivenSum {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in)
    var t = sc.nextInt()
    sc.nextLine()
    var a0 = 0
    while(a0 < t) {
      val line1 = sc.nextLine().split(" ")
      var line2 = sc.nextLine().split(" ").map(p1 => Integer.valueOf(p1)).toSeq
      var size = line1(0).toInt
      var sum = line1(1).toInt
      var i: Int = 0
      var j: Int = 0
      var currentSum: Int = line2.head
      while(i<size && j<size) {
        if(currentSum > sum) {
          currentSum = currentSum - line2(i)
          i = i + 1
        } else if(currentSum < sum) {
          j = j + 1
          currentSum = currentSum + line2(j)
        } else {
          println(s"$i, $j")
          i=size
        }
      }
      a0 += 1
    }
  }

}

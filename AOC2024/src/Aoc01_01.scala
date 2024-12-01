import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Aoc01_01 extends App {
  private val fn = "files/aoc01_input.txt"

  private var leftList: ArrayBuffer[Int] = ArrayBuffer()
  private var rightList: ArrayBuffer[Int] = ArrayBuffer()

  try {
    val src = Source.fromFile(fn)

    for (line <- src.getLines()) {
      val values: Array[String] = line.split(" {3}")
      leftList += Integer.parseInt(values(0))
      rightList += Integer.parseInt(values(1))
    }

    src.close()
  } catch {
    case e: Exception => throw e
  }

  leftList = leftList.sorted
  rightList = rightList.sorted

  private var sum = 0
  for (i <- leftList.indices)
    sum += math.abs(rightList(i) - leftList(i))

  println(sum)
}

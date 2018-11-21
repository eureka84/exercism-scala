import scala.collection.mutable
import scala.util.Random

class Robot {
 import Robot._
  var name: String = generateName()

  def reset(){
    this.name = generateName()
  }
}

object Robot {
  val A_ASCII_CODE = 65
  val ALPHABET_SIZE = 26

  private val alreadySet = mutable.HashSet.empty[String]

  private def aChar: Char = (A_ASCII_CODE + Random.nextInt(ALPHABET_SIZE)).toChar
  private def aNumber: Int = Random.nextInt(10)

  private def buildRandomName = s"$aChar$aChar$aNumber$aNumber$aNumber"

  private def generateName(): String = {
    var randomName = buildRandomName
    while (alreadySet.contains(randomName)){
      randomName = buildRandomName
    }
    alreadySet.add(randomName)
    randomName
  }

}

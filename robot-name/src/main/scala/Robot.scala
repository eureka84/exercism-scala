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
  private val A_ASCII_CODE = 65
  private val ALPHABET_SIZE = 26

  private val alreadySet = mutable.HashSet.empty[String]

  private def aChar: Char = (A_ASCII_CODE + Random.nextInt(ALPHABET_SIZE)).toChar
  private def aNumber: Int = Random.nextInt(10)

  private def aRobotName = s"$aChar$aChar$aNumber$aNumber$aNumber"

  private def generateName(): String = {
    var randomName = aRobotName
    while (alreadySet.contains(randomName)){
      randomName = aRobotName
    }
    alreadySet.add(randomName)
    randomName
  }

}

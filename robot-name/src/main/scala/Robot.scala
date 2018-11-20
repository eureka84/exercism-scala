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

  private val alreadySet = mutable.HashSet.empty[String]

  private def randomChar: Char = {
    val offset = 65 + Random.nextInt(26)
    offset.toChar
  }
  private def randomNumber: Int = Random.nextInt(10)

  private def buildRandomName = s"$randomChar$randomChar$randomNumber$randomNumber$randomNumber"

  private def generateName(): String = {
    var randomName = buildRandomName
    while (alreadySet.contains(randomName)){
      randomName = buildRandomName
    }
    alreadySet.add(randomName)
    randomName
  }

}

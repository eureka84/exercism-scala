
object BeerSong {

  def recite(bottles: Int, take: Int): String =
    (bottles to (bottles - take + 1) by -1).map { bottlesOnTheWall => verse(bottlesOnTheWall) }.mkString("\n")

  private def verse(bottlesOnTheWall: Int) =
    firstVerse(bottlesOnTheWall) + secondVerse(bottlesOnTheWall, bottlesOnTheWall - 1)

  private def firstVerse(n: Int) = s"${n.bottles.capitalize} of beer on the wall, ${n.bottles} of beer.\n"

  private def secondVerse(current: Int, remaining: Int): String = (current, remaining) match {
    case (0, _) => "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    case (1, 0) => "Take it down and pass it around, no more bottles of beer on the wall.\n"
    case _ => s"Take one down and pass it around, ${remaining.bottles} of beer on the wall.\n"
  }

  private implicit class BottlesInt(n: Int) {
    def bottles: String = n match {
      case 1 => "1 bottle"
      case 0 => "no more bottles"
      case _ => s"$n bottles"
    }
  }

}

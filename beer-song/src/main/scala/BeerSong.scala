
object BeerSong {

  def recite(bottles: Int, take: Int): String =
    (bottles to (bottles - take + 1) by -1).map { bottlesOnTheWall => verse(bottlesOnTheWall) }.mkString("\n")

  private def verse(bottlesOnTheWall: Int) =
    firstVerse(bottlesOnTheWall) + secondVerse(bottlesOnTheWall, bottlesOnTheWall - 1)

  private def firstVerse(n: Int) = s"${bottles(n).capitalize} of beer on the wall, ${bottles(n)} of beer.\n"

  private def secondVerse(current: Int, remaining: Int): String = current match {
    case 0 => s"Go to the store and buy some more, ${onTheWall(99)}"
    case 1 => s"Take it down and pass it around, ${onTheWall(remaining)}"
    case _ => s"Take one down and pass it around, ${onTheWall(remaining)}"
  }

  private def onTheWall(n: Int): String = s"${bottles(n)} of beer on the wall.\n"

  def bottles(n: Int): String = n match {
    case 1 => "1 bottle"
    case 0 => "no more bottles"
    case _ => s"$n bottles"
  }

}

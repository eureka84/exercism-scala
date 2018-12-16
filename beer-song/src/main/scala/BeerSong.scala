
object BeerSong {

  def recite(bottles: Int, take: Int): String =
    (bottles to (bottles - take + 1) by -1).map { bottlesOnTheWall => verse(bottlesOnTheWall) }.mkString("\n")

  private def verse(n: Int) = firstVerse(n) + secondVerse(n)

  private def firstVerse(n: Int) = s"${onTheWall(n).capitalize}, ${bottles(n)} of beer.\n"

  private def secondVerse(n: Int): String = n match {
    case 0 => s"Go to the store and buy some more, ${onTheWall(99)}.\n"
    case 1 => s"Take it down and pass it around, ${onTheWall(n - 1)}.\n"
    case _ => s"Take one down and pass it around, ${onTheWall(n - 1)}.\n"
  }

  private def onTheWall(n: Int): String = s"${bottles(n)} of beer on the wall"

  def bottles(n: Int): String = n match {
    case 1 => "1 bottle"
    case 0 => "no more bottles"
    case _ => s"$n bottles"
  }

}

package Model

case class Spaceship(x: Int, y: Int) extends GameObject {
  val up = "↑"
  val down = "↓"
  val right = "→"
  val left = "←"
}

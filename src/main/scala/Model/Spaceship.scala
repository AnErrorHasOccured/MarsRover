package Model

case class Spaceship(TerrainLeght: Int, TerreinHeight: Int) extends GameObject {
  val up = "↑"
  val down = "↓"
  val right = "→"
  val left = "←"
  override val x: Int = 0
  override val y: Int = 0
}

package Model

case class Obstacle(x: Int, y: Int) extends GameObject {
  override def getIcon: String = {
    "X"
  }
}

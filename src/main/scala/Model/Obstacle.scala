package Model

case class Obstacle(override var position: Position) extends GameObject {
  override def getIcon: String = {
    "X"
  }
}

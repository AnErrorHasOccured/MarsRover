package Model

case class Obstacle(override var x: Int, override var y: Int) extends GameObject {
  override def getIcon: String = {
    "X"
  }
}

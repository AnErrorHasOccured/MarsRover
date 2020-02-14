package Model

case class Obstacle(override var position: Position) extends GameObject {
  var Icon: String = "X"
}

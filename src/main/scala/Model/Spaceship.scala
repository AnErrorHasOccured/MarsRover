package Model

case class Spaceship(override var x: Int, override var y: Int, terrainLength: Int, terrainHeight: Int) extends GameObject {
  val up = "↑"
  val down = "↓"
  val right = "→"
  val left = "←"
  var currentIcon: String = up

  override def getIcon: String = {
    currentIcon
  }

  def Move(command: String): Unit =
    command match {
      case "r" => MoveRight()
      case "l" => MoveLeft()
      case "u" => MoveUp()
      case "d" => MoveDown()
    }

  private def MoveRight(): Unit = {
    if (currentIcon == right)
      x = x + 1
    else
      currentIcon = right

    if (x > terrainLength)
      x = 1
  }

  private def MoveLeft(): Unit = {
    if (currentIcon == left)
      x = x - 1
    else
      currentIcon = left

    if (x <= 0)
      x = terrainLength
  }

  private def MoveUp(): Unit = {
    if (currentIcon == up)
      y = y - 1
    else
      currentIcon = up

    if (y <= 0)
      y = terrainHeight
  }

  private def MoveDown(): Unit = {
    if (currentIcon == down)
      y = y + 1
    else
      currentIcon = down

    if (y > terrainHeight)
      y = 1
  }
}

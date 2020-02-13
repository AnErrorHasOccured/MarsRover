package Model

import scala.collection.mutable.ListBuffer

final case class Spaceship(override var position: Position, terrainLength: Int, terrainHeight: Int) extends GameObject {
  private val up = "↑"
  private val down = "↓"
  private val right = "→"
  private val left = "←"
  private var currentIcon: String = up

  override def getIcon: String = currentIcon

  def Move(command: String): Unit =
    command match {
      case "r" => MoveRight()
      case "l" => MoveLeft()
      case "u" => MoveUp()
      case "d" => MoveDown()
      case _ => println("INVALID COMMAND!1!")
    }

  def FindsGamesObjects(obstacle: ListBuffer[GameObject]): Boolean =
    obstacle.exists(a => a.position == position)

  private def MoveRight(): Unit = {
    if (currentIcon == right)
      position.x = position.x + 1
    else
      currentIcon = right

    if (position.x > terrainLength)
      position.x = 1
  }

  private def MoveLeft(): Unit = {
    if (currentIcon == left)
      position.x = position.x - 1
    else
      currentIcon = left

    if (position.x <= 0)
      position.x = terrainLength
  }

  private def MoveUp(): Unit = {
    if (currentIcon == up)
      position.y = position.y - 1
    else
      currentIcon = up

    if (position.y <= 0)
      position.y = terrainHeight
  }

  private def MoveDown(): Unit = {
    if (currentIcon == down)
      position.y = position.y + 1
    else
      currentIcon = down

    if (position.y > terrainHeight)
      position.y = 1
  }
}

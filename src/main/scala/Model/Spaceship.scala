package Model

import scala.collection.mutable.ListBuffer

final case class Spaceship(override var position: Position, private val terrain: Terrain) extends GameObject {
  private val up = "↑"
  private val down = "↓"
  private val right = "→"
  private val left = "←"
  var Icon: String = up

  private def setIcon(icon: String): Unit = Icon = icon

  def Move(command: String): Unit =
    command match {
      case "r" => MoveRight()
      case "l" => MoveLeft()
      case "u" => MoveUp()
      case "d" => MoveDown()
      case _ => println("INVALID COMMAND!1!")
    }

  def isBoomWith(obstacle: ListBuffer[GameObject]): Boolean = obstacle.exists(a => a.position == position)

  private def MoveRight(): Unit = {
    if (Icon == right)
      moveToRight()
    else
      setIcon(right)

    def moveToRight(): Unit = {
      position.x += 1
      if (position.x > terrain.Length)
        position.x = 1
    }
  }

  private def MoveLeft(): Unit = {
    if (Icon == left)
      moveToLeft()
    else
      setIcon(left)

    def moveToLeft(): Unit = {
      position.x -= 1
      if (position.x <= 0)
        position.x = terrain.Length
    }
  }

  private def MoveUp(): Unit = {
    if (Icon == up)
      moveToUp()
    else
      setIcon(up)

    def moveToUp(): Unit = {
      position.y = position.y - 1
      if (position.y <= 0)
        position.y = terrain.Height
    }
  }

  private def MoveDown(): Unit = {
    if (Icon == down)
      moveToDown()
    else
      setIcon(down)

    def moveToDown(): Unit = {
      position.y = position.y + 1
      if (position.y > terrain.Height)
        position.y = 1
    }
  }
}

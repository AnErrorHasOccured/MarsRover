import Model.{GameObject, Obstacle, Spaceship}

import scala.collection.mutable.ListBuffer

object Drawer {
  private val Roof = "____"
  private val RowPattern = "|   "
  private val EndRow = "|"
  private val BaseRow = "|___"

  def PrintTerrainPart(obj: String, cells: Int): Unit = {
    var row = ""
    for (w <- 1 to cells)
      row += obj

    println(row + EndRow)
  }

  def PrintObject(gamesObjects: ListBuffer[GameObject], cells: Int, y : Int): Unit = {
    var row = ""

    for (x <- 1 to cells) {
      val gameToPrint = gamesObjects.find(obj => obj.x == x && obj.y == y )
      if (gameToPrint.isDefined)
        row += RowPattern.substring(0, 2) + gameToPrint.head.getIcon + RowPattern.substring(3)
      else
        row += RowPattern
    }

    println(row + EndRow)
  }

  def Terrain(length: Int, height: Int, gamesObjects: ListBuffer[GameObject]): Unit = {
    println()
    for (y <- 1 to height) {
      PrintTerrainPart(RowPattern, length)

      if (gamesObjects.exists(_.y == y))
        PrintObject(gamesObjects, length, y)
      else
        PrintTerrainPart(RowPattern, length)

      PrintTerrainPart(BaseRow, length)
    }
  }
}
import Model.{GameObject, Position}

import scala.collection.mutable.ListBuffer

object Drawer {

  private val Roof = "____"
  private val RowPattern = "|   "
  private val EndRow = "|"
  private val BaseRow = "|___"

  private def AddRow(str: String): String = str + "\n"

  private def GetRoof(cells: Int): String = {
    var row = ""
    for (w <- 1 to cells)
      row += Roof

    AddRow(row + Roof.charAt(0))
  }

  private def GetTerrainPart(obj: String, cells: Int): String = {
    var row = ""
    for (w <- 1 to cells)
      row += obj

    AddRow(row + EndRow)
  }

  private def GetTerrainObject(gamesObjects: ListBuffer[GameObject], cells: Int, y: Int): String = {
    var row = ""

    for (x <- 1 to cells) {
      val actualPosition = Position(x, y)
      val gameToPrint = gamesObjects.find(obj => obj.position == actualPosition)

      if (gameToPrint.nonEmpty)
        row += RowPattern.substring(0, 2) + gameToPrint.head.Icon + RowPattern.substring(3)
      else
        row += RowPattern
    }

    AddRow(row + EndRow)
  }

  def Terrain(length: Int, height: Int, gamesObjects: ListBuffer[GameObject]): String = {
    var terrain = ""

    terrain += GetRoof(length)
    for (y <- 1 to height) {
      terrain += GetTerrainPart(RowPattern, length)
      terrain += GetTerrainObject(gamesObjects, length, y)
      terrain += GetTerrainPart(BaseRow, length)
    }

    terrain
  }
}
import Model.GameObject

import scala.collection.mutable.ListBuffer

object Drawer {
  private val Roof = "____"
  private val RowPattern = "|   "
  private val EndRow = "|"
  private val BaseRow = "|___"

  def PrintRoof(cells: Int): Unit = {
    var row = ""
    for (w <- 1 to cells)
      row += Roof

    println(row + Roof.charAt(0))
  }

  def PrintTerrainPart(obj: String, cells: Int): Unit = {
    var row = ""
    for (w <- 1 to cells)
      row += obj

    println(row + EndRow)
  }

  def PrintObject(gamesObjects: ListBuffer[GameObject], cells: Int, y: Int): Unit = {
    var row = ""

    for (x <- 1 to cells) {
      val gameToPrint = gamesObjects.find(obj => obj.x == x && obj.y == y)

      if (gameToPrint.nonEmpty)
        row += RowPattern.substring(0, 2) + gameToPrint.head.getIcon + RowPattern.substring(3)
      else
        row += RowPattern
    }

    println(row + EndRow)
  }

  def Terrain(length: Int, height: Int, gamesObjects: ListBuffer[GameObject]): Unit = {
    PrintRoof(length)
    for (y <- 1 to height) {
      PrintTerrainPart(RowPattern, length)
      PrintObject(gamesObjects, length, y)
      PrintTerrainPart(BaseRow, length)
    }
  }
}
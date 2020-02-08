import Model.{GameObject, Spaceship}

object Drawer {
  private val Roof = "____"
  private val InitialRow = "|   "
  private val MiddleRow = "| x "
  private val EndRow = "|"
  private val BaseRow = "|___"

  def PrintTerrainPart(obj: String, cells: Int): Unit = {
    var row = ""
    for (w <- 1 to cells)
      row += obj

    println(row + EndRow)
  }

  def PrintObject(spaceship: GameObject, cells: Int): Unit = {
    var row = ""
    for (i <- 1 to cells)
      if (spaceship.x == i)
        row += MiddleRow.replace("x", "↑")
      else
        row += MiddleRow.replace("x", " ")

    println(row + EndRow)
  }

  def Terrain(length: Int, height: Int, spaceship: Spaceship): Unit = {
    println()
    for (i <- 1 to height) {
      PrintTerrainPart(InitialRow, length)

      if (spaceship.y == i)
        PrintObject(spaceship, length)
      else
        PrintTerrainPart(InitialRow, length)

      PrintTerrainPart(BaseRow, length)
    }
  }
}
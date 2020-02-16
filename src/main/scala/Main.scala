import Exceptions.BoomException
import Model.Terrain

import Console.{GREEN, RED, RESET, UNDERLINED, YELLOW_B}
import scala.io.StdIn

object Main extends App {
  val TerrainLength = args(0).toInt
  val TerrainHeight = args(1).toInt
  val Obstacles = args(2).toInt

  val terrain = Terrain(TerrainLength, TerrainHeight)
  val (spaceship, obstacles) = Instanziator(terrain, Obstacles).GetGamesObjects
  val gamesObjects = spaceship +: obstacles

  PrintInfo()

  try {
    while (true) {
      val terrainString = Drawer.Terrain(terrain, gamesObjects)
      println(terrainString)

      spaceship.Move(StdIn.readLine())
      if (spaceship.isBoomWith(obstacles))
        throw BoomException()
    }
  } catch {
    case e: Exception => Console.err.println(e.getMessage)
  }

  def PrintInfo(): Unit = {
    Console.println(s"${RESET}${GREEN}WELCOME TO MARS ROVER GAME")
    Console.println(s"u -> up")
    Console.println(s"r -> right")
    Console.println(s"d -> down")
    Console.println(s"l -> left ${RESET}")
  }
}

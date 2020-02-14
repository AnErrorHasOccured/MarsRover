import Exceptions.BoomException
import Console.{GREEN, RED, RESET, YELLOW_B, UNDERLINED}
import scala.io.StdIn

object Main extends App {
  val TerrainLength = args(0).toInt
  val TerrainHeight = args(1).toInt
  val Obstacles = args(2).toInt

  val (spaceship, obstacles) = Instanziator(TerrainLength, TerrainHeight, Obstacles).GetGamesObjects
  val gamesObjects = spaceship +: obstacles

  PrintInfo()

  try {
    while (true) {
      val terrain = Drawer.Terrain(TerrainLength, TerrainHeight, gamesObjects)
      println(terrain)

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

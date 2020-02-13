import Exceptions.BoomException
import Console.{GREEN, RED, RESET, YELLOW_B, UNDERLINED}
import scala.io.StdIn

object Main extends App {
  val Length = 6
  val Height = 3
  val Obstacles = 3

  PrintInfo()
  val (spaceship, obstacles) = Instanziator(Length, Height, Obstacles).GetInstances

  try {
    while (true) {
      if (spaceship.HasDuplicationCoordinates(obstacles))
        throw BoomException()

      Drawer.Terrain(Length, Height, spaceship +: obstacles)

      spaceship.Move(StdIn.readLine())
    }
  } catch {
    case e: Exception => Console.err.println(e.getMessage)
  }

  def PrintInfo(): Unit = {
    Console.println(s"${RESET}${GREEN}WELCOME TO MARS ROVER GAME")
    Console.println(s"Type: u -> up")
    Console.println(s"      r -> right")
    Console.println(s"      d -> down")
    Console.println(s"      l -> left ${RESET}")
  }
}

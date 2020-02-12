import scala.io.StdIn

object Main extends App {
  val Length = 6
  val Height = 3
  val Obstacle = 3

  val (spaceship, obstacles) = Instanziator(Length, Height, Obstacle).GetInstances
  Drawer.Terrain(Length, Height, spaceship +: obstacles)

  while (true) {
    val input = StdIn.readLine()

    spaceship.Move(input)
    Drawer.Terrain(Length, Height, spaceship +: obstacles)
  }
}

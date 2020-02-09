import Model.Spaceship

object Main extends App {
  val Length = 6
  val Height = 3

  val (deltaOne, obstacles) = Instanziator(Length, Height, 2).GetInstances()
  Drawer.Terrain(Length, Height, deltaOne)
}

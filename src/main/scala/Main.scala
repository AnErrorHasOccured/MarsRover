import Model.Spaceship

object Main extends App {
  val Lenght = 6
  val Height = 3

  var deltaOne = Spaceship(1, 1)
  Drawer.Terrain(Lenght, Height, deltaOne)
}


object Main extends App {
  val Length = 6
  val Height = 3

  println()

  var (deltaOne, obstacles) = Instanziator(Length, Height, 2).GetInstances
  Drawer.Terrain(Length, Height, deltaOne, obstacles)
}

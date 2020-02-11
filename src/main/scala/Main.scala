
object Main extends App {
  val Length = 6
  val Height = 3

  var gamesObjects = Instanziator(Length, Height, 2).GetInstances
  Drawer.Terrain(Length, Height, gamesObjects)
}

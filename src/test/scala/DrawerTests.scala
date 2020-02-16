import Model.{GameObject, Obstacle, Position, Spaceship, Terrain}
import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.ListBuffer

class DrawerTests extends AnyFlatSpec {

  val terrain: Terrain = Terrain(6, 3)
  val spaceship: Spaceship = Spaceship(Position(4, 3), terrain)
  val obstacles: ListBuffer[GameObject]  = ListBuffer(Obstacle(Position(2, 2)), Obstacle(Position(2, 3)), spaceship)
  val gamesObjects: ListBuffer[GameObject] = (spaceship +: obstacles)
  val terrainString: String = Drawer.Terrain(terrain, gamesObjects)

  it should "Draw GamesObjects in the right position" in {
    gamesObjects.foreach(x => {
      for (i <- 1 to terrain.Height) {
        if (x.position.y == i) {
          val terrainRow = terrainString.split("\n").take(i * 3)
          val element = terrainRow.find(_.contains(x.Icon))
          assert(element.isDefined)
        }
      }
    })
  }
}

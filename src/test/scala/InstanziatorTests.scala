import Model.Terrain
import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {

  val terrain: Terrain = Terrain(6, 4)
  val numberObstacles = 2
  val (spaceship, obstacles) = Instanziator(terrain, numberObstacles).GetGamesObjects

  it should "GamesObjects has no duplicate coordinates " in {
    val gamesObjects = spaceship +: obstacles
    assert(gamesObjects.exists(a => gamesObjects.exists(b => a.position != b.position)))
  }

  it should "Return right number of obstacles" in {
    assert(obstacles.length == numberObstacles)
  }
}
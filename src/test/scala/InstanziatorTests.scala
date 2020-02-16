import Exceptions.TooMuchObstaclesException
import Model.Terrain
import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {

  it should "GamesObjects has no duplicate coordinates " in {
    val terrain: Terrain = Terrain(6, 4)
    val numberObstacles = 2
    val (spaceship, obstacles) = Instanziator(terrain, numberObstacles).GetGamesObjects
    val gamesObjects = spaceship +: obstacles

    assert(gamesObjects.exists(a => gamesObjects.exists(b => a.position != b.position)))
  }

  it should "Return right number of obstacles" in {
    val terrain: Terrain = Terrain(6, 4)
    val numberObstacles = 2
    val (_, obstacles) = Instanziator(terrain, numberObstacles).GetGamesObjects

    assert(obstacles.length == numberObstacles)
  }

  it should "Instantiator should rise TooMuchObstaclesException" in {
    val terrain: Terrain = Terrain(2, 2)
    val numberObstacles = 5

    assertThrows[TooMuchObstaclesException] {
      Instanziator(terrain, numberObstacles)
    }
  }
}
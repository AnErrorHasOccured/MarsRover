import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {
  it should "GamesObjects has no duplicate coordinates " in {
    val (spaceship, obstacles) = Instanziator(6, 4, 2).GetGamesObjects
    val gamesObjects = spaceship +: obstacles

    assert(gamesObjects.exists(a => gamesObjects.exists(b => a.position != b.position)))
  }
}
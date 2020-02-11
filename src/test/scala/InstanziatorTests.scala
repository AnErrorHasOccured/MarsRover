import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {
  it should "GamesObjects has no duplicate coordinates " in {
    val gamesObjects = Instanziator(6, 4, 2).GetInstances

    assert(gamesObjects.exists(a => gamesObjects.exists(b => a.x != b.x || a.y != b.y)))
  }
}
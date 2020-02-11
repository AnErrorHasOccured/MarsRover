import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {
  it should "Spaceship has no duplicate coordinates " in {
    val (spaceship, obstacles) = Instanziator(6, 4, 2).GetInstances()

    assert(
      obstacles.forall(
        obstacle =>
          (obstacle.x != spaceship.x) || (obstacle.y != spaceship.y)
      )
    )
  }

  it should "Obstacle has no duplicate coordinates " in {
    val (_, obstacles) = Instanziator(6, 4, 2).GetInstances()

    assert(obstacles.exists(a => obstacles.exists(b => a.x != b.x || a.y != b.y)))
  }
}
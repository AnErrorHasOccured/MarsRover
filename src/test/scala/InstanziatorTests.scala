import org.scalatest.flatspec.AnyFlatSpec

class InstanziatorTests extends AnyFlatSpec {
  it should "Object Game has no duplicate coordinates " in {
    val (spaceship, obstacles) = Instanziator(6, 4, 2).GetInstances()

    println(spaceship.x)
    println(spaceship.y)
  }
}
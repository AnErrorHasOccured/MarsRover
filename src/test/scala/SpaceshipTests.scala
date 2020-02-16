import Model.{GameObject, Obstacle, Position, Spaceship, Terrain}
import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.ListBuffer

class SpaceshipTests extends AnyFlatSpec {

  val terrain: Terrain = Terrain(6, 4)

  it should "Spaceship should move right " in {
    val spaceship = Spaceship(Position(2, 2), terrain)

    spaceship.Move("r")
    spaceship.Move("r")

    assert(spaceship.position.x == 3)
  }

  it should "Spaceship should move left " in {
    val spaceship = Spaceship(Position(2, 2), terrain)

    spaceship.Move("l")
    spaceship.Move("l")

    assert(spaceship.position.x == 1)
  }

  it should "Spaceship should move up " in {
    val spaceship = Spaceship(Position(2, 2), terrain)

    spaceship.Move("u")

    assert(spaceship.position.y == 1)
  }

  it should "Spaceship should move down " in {
    val spaceship = Spaceship(Position(2, 2), terrain)

    spaceship.Move("d")
    spaceship.Move("d")

    assert(spaceship.position.y == 3)
  }

  it should "Spaceship should is Boom with obstalce " in {
    val position = Position(2, 2)
    val spaceship = Spaceship(position, terrain)
    val obstacles: ListBuffer[GameObject] = ListBuffer(Obstacle(position))

    assert(spaceship.isBoomWith(obstacles))
  }
}
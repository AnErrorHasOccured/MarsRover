import Model.{Obstacle, Spaceship}

import scala.collection.mutable.ListBuffer
import scala.util.Random

case class Instanziator(TerrainLength: Int, TerrainHeight: Int, ObstacleNumber: Int) {

  def GetInstances(): (Spaceship, ListBuffer[Obstacle]) = {
    var success = false
    val spaceship = Spaceship(Random.between(1, TerrainLength), Random.between(1, TerrainHeight))
    var obstacles = ListBuffer[Obstacle]()

    while (!success) {
      if (obstacles.length == ObstacleNumber) success = true

      val xRandom = Random.between(1, TerrainLength)
      val yRandom = Random.between(1, TerrainHeight)

      if ((spaceship.x != xRandom || spaceship.y != yRandom)
        && obstacles.forall(obstacle => obstacle.x != xRandom && obstacle.y != yRandom))
        obstacles += Obstacle(xRandom, yRandom)
    }

    (spaceship, obstacles)
  }
}

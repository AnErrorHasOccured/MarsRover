import Model.{Obstacle, Spaceship}

import scala.collection.mutable.ListBuffer
import scala.util.Random

case class Instanziator(TerrainLength: Int, TerrainHeight: Int, ObstacleNumber: Int) {

  def GetInstances(): (Spaceship, ListBuffer[Obstacle]) = {
    var success = false
    var obstacles = ListBuffer[Obstacle]()
    val spaceship: Spaceship = GetSpaceship

    while (!success) {
      if (obstacles.length == ObstacleNumber) success = true

      val obstacle = getObstacle(spaceship, obstacles)
      if (obstacle != null)
        obstacles += obstacle
    }

    (spaceship, obstacles)
  }

  private def GetSpaceship : Spaceship = {
    val (xRandom, yRandom) = GetRandomCoordinate
    Spaceship(xRandom, yRandom)
  }

  private def getObstacle(spaceship: Spaceship, obstacles: ListBuffer[Obstacle]): Obstacle = {
    val (xRandom, yRandom) = GetRandomCoordinate

    if ((spaceship.x != xRandom || spaceship.y != yRandom)
      && obstacles.forall(obstacle => obstacle.x != xRandom || obstacle.y != yRandom))
      return Obstacle(xRandom, yRandom)

    null
  }

  private def GetRandomCoordinate: (Int, Int) = {
    (Random.between(1, TerrainLength), Random.between(1, TerrainHeight))
  }
}

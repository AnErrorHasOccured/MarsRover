import Model.{GameObject, Obstacle, Position, Spaceship}

import scala.collection.mutable.ListBuffer
import scala.util.Random

final case class Instanziator(TerrainLength: Int, TerrainHeight: Int, ObstacleNumber: Int) {

  def GetInstances: (Spaceship, ListBuffer[GameObject]) = {
    var success = false
    var obstacles = ListBuffer[GameObject]()
    val spaceship = GetSpaceship

    while (!success) {
      if (obstacles.length == ObstacleNumber - 1) success = true

      val obstacle = GetObstacle(spaceship, obstacles)
      if (obstacle != null)
        obstacles += obstacle
    }

    (spaceship, obstacles)
  }

  private def GetSpaceship: Spaceship = {
    val randomPosition = GetRandomCoordinate
    Spaceship(randomPosition, TerrainLength, TerrainHeight)
  }

  private def GetObstacle(spaceship: Spaceship, obstacles: ListBuffer[GameObject]): Obstacle = {
    val randomPosition = GetRandomCoordinate

    if (spaceship.position != randomPosition
      && obstacles.forall(obstacle => obstacle.position != randomPosition))
      return Obstacle(randomPosition)

    null
  }

  private def GetRandomCoordinate: Position = {
    Position(Random.between(1, TerrainLength + 1), Random.between(1, TerrainHeight + 1))
  }
}

import Model.{GameObject, Obstacle, Position, Spaceship}

import scala.collection.mutable.ListBuffer
import scala.util.Random

final case class Instanziator(TerrainLength: Int, TerrainHeight: Int, ObstacleNumber: Int) {

  def GetGamesObjects: (Spaceship, ListBuffer[GameObject]) = {
    var success = false
    var obstacles = ListBuffer[GameObject]()
    val spaceship = GetSpaceship

    while (!success) {
      val obstacle = GetObstacle(spaceship, obstacles)

      obstacle match {
        case Some(o) => obstacles += o
        case _ =>
      }

      if (obstacles.length == ObstacleNumber)
        success = true
    }

    (spaceship, obstacles)
  }

  private def GetSpaceship: Spaceship = {
    val randomPosition = GetRandomCoordinate
    Spaceship(randomPosition, TerrainLength, TerrainHeight)
  }

  private def GetObstacle(spaceship: Spaceship, obstacles: ListBuffer[GameObject]): Option[Obstacle] = {
    val randomPosition = GetRandomCoordinate

    if (spaceship.position != randomPosition
      && obstacles.forall(obstacle => obstacle.position != randomPosition))
      return Some(Obstacle(randomPosition))

    null
  }

  private def GetRandomCoordinate: Position = {
    Position(Random.between(1, TerrainLength + 1), Random.between(1, TerrainHeight + 1))
  }
}

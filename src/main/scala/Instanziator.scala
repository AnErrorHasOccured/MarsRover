import Model.{GameObject, Obstacle, Position, Spaceship, Terrain}

import scala.collection.mutable.ListBuffer
import scala.util.Random

final case class Instanziator(terrain: Terrain, ObstacleNumber: Int) {

  def GetGamesObjects: (Spaceship, ListBuffer[GameObject]) = {
    val spaceship = GetSpaceship
    val obstacles = GetListObstacle(spaceship)

    (spaceship, obstacles)
  }

  private def GetListObstacle(spaceship: Spaceship) : ListBuffer[GameObject] = {
    var success = false
    var obstacles = ListBuffer[GameObject]()

    while (!success) {
      val obstacle = GetObstacle(spaceship, obstacles)

      obstacle match {
        case Some(o) => obstacles += o
        case _ =>
      }

      if (obstacles.length == ObstacleNumber)
        success = true
    }

    obstacles
  }

  private def GetSpaceship: Spaceship = {
    val randomPosition = GetRandomCoordinate
    Spaceship(randomPosition, terrain)
  }

  private def GetObstacle(spaceship: Spaceship, obstacles: ListBuffer[GameObject]): Option[Obstacle] = {
    val randomPosition = GetRandomCoordinate

    if (spaceship.position != randomPosition
      && obstacles.forall(obstacle => obstacle.position != randomPosition))
      return Some(Obstacle(randomPosition))

    null
  }

  private def GetRandomCoordinate: Position = {
    Position(Random.between(1, terrain.Length + 1), Random.between(1, terrain.Height + 1))
  }
}

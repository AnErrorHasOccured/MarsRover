package Exceptions

import Model.Terrain

final case class TooMuchObstaclesException(private val terrain: Terrain) extends Exception("TOO MUCH OBSTACLE FOR TERRAIN" + s" ${terrain.Height} X ${terrain.Length}")
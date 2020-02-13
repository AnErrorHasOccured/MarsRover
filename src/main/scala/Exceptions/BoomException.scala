package Exceptions

final case class BoomException(private val msg: String = "ROVER BOOOOOOM!!!") extends Exception(msg)
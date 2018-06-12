package models

import Book._

class Book(val id: Long, val name: String) {
}

object Book {
  val idOfGnere = Map(
    1 -> "ruby",
    2 -> "java",
    3 -> "scala",
    4 -> "python",
    5 -> "javascript",
    6 -> "php",
    7 -> "html",
    8 -> "css",
    9 -> "C++",
    10 -> "G"
  )

  def getGenreName(id: Int):Option[String] = {
    idOfGnere.get(id)
  }
  val genres = List (
    Map (
      "id"-> "1",
      "name"-> "ruby"
    ),
    Map (
      "id"-> "2",
      "name"-> "java"
    ),
    Map (
      "id"-> "3",
      "name"-> "scala"
    ),
    Map (
      "id"-> "4",
      "name"-> "python"
    ),
    Map (
      "id"-> "5",
      "name"-> "javascript"
    ),
    Map (
      "id"-> "6",
      "name"-> "php"
    ),
    Map (
      "id"-> "7",
      "name"-> "html"
    ),
    Map (
      "id"-> "8",
      "name"-> "css"
    ),
    Map (
      "id"-> "9",
      "name"-> "C++"
    ),
    Map (
      "id"-> "10",
      "name"-> "go"
    )
  )
}


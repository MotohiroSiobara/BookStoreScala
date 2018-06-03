package controllers

import ApiController._ // コンパニオンオブジェクトであるApiControllerを利用するため
import play.api.mvc._
import play.api.libs.json._

object Type {
  type genreType = List[Genre]
}
case class BookGenre(genres: Type.genreType)
case class Genre(id: Int, name: String)

class ApiController extends Controller {
  def index = TODO //指定したジャンルに基づく技術書のリスト

  def genres = Action { implicit request =>
    Ok(genresJson)
  }
}

object ApiController {
  private val genresJson = Json.parse("""
    {
      "kind": "genres",
       "items": [
         {
            "id": "1",
            "name": "ruby"
         },
         {
            "id": "2",
            "name": "java"
          },
          {
            "id": "3",
            "name": "scala"
          },
          {
            "id": "4",
            "name": "python"
          },
          {
            "id": "5",
            "name": "javascript"
          },
          {
            "id": "6",
            "name": "php"
          },
          {
            "id": "7",
            "name": "html"
          },
          {
            "id": "8",
            "name": "css"
          },
          {
            "id": "9",
            "name": "C++"
          },
          {
            "id": "10",
            "name": "go"
          }
       ]
    }
  """)
}
package controllers

import ApiController._
import play.api.mvc._
import play.api.libs.json._
import api.RakutenApi
import models._

class ApiController extends Controller {
  def searchBooks = Action { implicit request =>
    val queryString = request.queryString
    println(queryString.getOrElse("page", None))
    val genreId = queryString.get("genre_id").map(_.last.toInt)
    val queryPage = queryString.get("page").map(_.last)
    genreId match {
      case Some(id) => Ok(genreSearchJson(id, queryPage))
      case None => Ok(wrongParameterJson)
    }
  }

  def genres = Action { implicit request =>
    Ok(genresJson)
  }

  private def genreSearchJson(id: Int, page: Option[String]):JsValue = {
    val optionName: Option[String] = Book.getGenreName(id)
    val json :JsValue = optionName match {
      case Some(f) => Json.parse(new RakutenApi().search(optionName.get)(page))
      case None    => notFoundDataJson
    }

    return json
  }
}

object ApiController {
  private val genresJson = Json.toJson(
    Book.genres
  )

  private val badRequestJson:JsValue = Json.parse("""
  {
      "error": "Bad Request",
      "message": "Not present with id"
  }
  """)

  private val wrongParameterJson:JsValue = Json.parse("""
    {
      "error": "wrong_parameter",
      "error_description": "keyword parameter is not valid"
    }
    """)

  private val notFoundDataJson:JsValue = Json.parse(
    """
      {
        "error": "not_found",
        "error_description": "not found"
      }
    """)
}

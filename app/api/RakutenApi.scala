package api

import RakutenApi._
import com.typesafe.config.{ConfigFactory}


class RakutenApi() {
  def search(keyword: String)(page: Option[String]) = {
    val params = "&keyword=" + keyword + "&page=" + page.getOrElse("page", "1")

    scala.io.Source.fromURL(endPoint + params).mkString
  }
}

object RakutenApi {
  private val endPoint = "https://app.rakuten.co.jp/services/api/Kobo/EbookSearch/20170426?koboGenreId=101912005001&format=json&applicationId=" + ConfigFactory.load().getString("rakuten.application.id")
}

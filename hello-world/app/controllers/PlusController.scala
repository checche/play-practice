package controllers

import javax.inject.Inject
import javax.inject.Singleton
import play.api.i18n.{I18nSupport, Messages}
import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.ControllerComponents
import play.api.mvc.Request

@Singleton
class PlusController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  val logger = play.api.Logger("plus")

  def get(a: Option[String], b: Option[String]) =
    Action {implicit request: Request[AnyContent] =>
      logger.info(s"a: $a, b: $b")
      Ok {
        try {
          a
            .flatMap(x => b.map(y => Messages("add", x, y, x.toInt + y.toInt)))
            .getOrElse(Messages("noNumber"))
        } catch {case e:NumberFormatException =>
          Messages("invalidNumber")}
      }
    }
}
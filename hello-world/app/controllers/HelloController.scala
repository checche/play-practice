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
class HelloController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  def get(name: Option[String]) =
    Action {implicit request: Request[AnyContent] =>
      Ok {
        name
          .map(s => Messages("hello", s))
          .getOrElse(Messages("noQuery"))
      }
    }
}

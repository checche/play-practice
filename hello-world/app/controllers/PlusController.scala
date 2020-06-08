package controllers

import javax.inject.Inject
import javax.inject.Singleton
import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.ControllerComponents
import play.api.mvc.Request

@Singleton
class PlusController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def get(a: Option[String], b: Option[String]) =
    Action {implicit request: Request[AnyContent] =>
      Ok {
        a
          .flatMap(x => b.map(y => s"${x.toInt + y.toInt}"))
          .getOrElse("""Please give arguments of a and b.""")
      }
    }
}
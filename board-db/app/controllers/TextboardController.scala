package controllers

import javax.inject.{Singleton, Inject}
import java.time.OffsetDateTime
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, MessagesApi}


case class PostRequest(body: String)

@Singleton
class TextboardController @Inject()(override val messagesApi: MessagesApi)(cc: ControllerComponents)
  extends AbstractController(cc)
  with I18nSupport {

  private[this] val form = Form(
    mapping(
      "post" -> text(minLength = 1, maxLength = 10)
    )(PostRequest.apply)(PostRequest.unapply))

  def get = Action { implicit request =>
    Ok(views.html.index(PostRepository.findAll, form))
  }

  def post = Action { implicit request =>
    form.bindFromRequest.fold(
      error => BadRequest(views.html.index(PostRepository.findAll, error)),
      postRequest => {
        val post = Post(postRequest.body, OffsetDateTime.now)
        PostRepository.add(post)
        Redirect("/")
      }
    )
  }
}

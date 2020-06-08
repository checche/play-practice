package controllers

import org.scalatestplus.play.PlaySpec
import play.api.test.FakeRequest
import play.api.test.Helpers._

class PlusControllerSpec extends PlaySpec {

  def controller = new PlusController(stubControllerComponents())

  "get" should {
    "クエリーパラメータがある場合はそれらの和を返す" in {
      val a = "2"
      val b = "3"
      val sum = a.toInt + b.toInt
      val result = controller.get(Some(a), Some(b))(FakeRequest())
      assert(status(result) === 200)
      assert(contentAsString(result) === s"$sum")
    }

    """クエリーパラメータがない場合は「Please give arguments of a and b.」というレスポンスを返す""" in {
      val result = controller.get(None, None)(FakeRequest())
      assert(status(result) === 200)
      assert(contentAsString(result) === """Please give arguments of a and b.""")
    }

    """クエリパラメータが不正なときは「Please input number」というレスポンスを返す""" in {
      val a = ""
      val b = "1"
      val result = controller.get(Some(a), Some(b))(FakeRequest())
      assert(status(result) === 200)
      assert(contentAsString(result) === """Please input number""")
    }
  }
}

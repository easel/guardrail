package swagger

import org.scalatest.{FunSuite, Matchers}
import clients.Implicits

class EscapingTest extends FunSuite with Matchers {
  test("Properly escape parameters") {
    Implicits.Formatter.addPath("foo bar baz") shouldEqual "foo%20bar%20baz"
    Implicits.Formatter.addPath("foo/bar") shouldEqual "foo%2Fbar"
    Implicits.Formatter.addArg("my key", "3=foo/bar baz!") shouldEqual "&my+key=3%3Dfoo/bar+baz!"
  }
}

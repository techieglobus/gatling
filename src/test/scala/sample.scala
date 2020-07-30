import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Sample extends Simulation {

  val httpProtocol = http.baseUrl("http://dummy.restapiexample.com")
  var scn = scenario("Test APIs")

    .exec(
        http("Get Employees")
        .get("/api/v1/employees")
    )
    .exec(
        http("Get Individual Details Using ID")
        .get("/api/v1/employee/2")
    )
    .exec(
        http("First POST Request")
        .post("/api/v1/create")
        .headers(Map(
                        "User-Agent" -> "Safari/602.1",
                        "Content-Type" -> "application/json"
                        )
                    )
       // .body(StringBody("""${randsession}"""))
       .body(StringBody(""" {"name":"Sammy","salary":"10000000","age":"30"} """))
       .check(status.is(200))
    )   

    setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
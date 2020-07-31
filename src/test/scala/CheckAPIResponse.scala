import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckAPIResponse extends Simulation {
  
    val httpProtocol = http.baseUrl("http://dummy.restapiexample.com")
    val scn = scenario(scenarioName="Check API Response")

    .exec(http(requestName="Get Specific Employee")
     .get("/api/v1/employees")
    .check(status.is(expected="200")))

     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
    val price = System.getProperty("price")
    printf("<price>%s</price>",price)
}

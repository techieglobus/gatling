import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class CheckAPIResponse extends Simulation {
  
    val httpProtocol = http.baseUrl("http://localhost:3000")
    val bodyFile = "./src/test/scala/sample.json"
    val content = Source.fromFile(bodyFile).getLines.mkString

    val scn = scenario(scenarioName="Check API Response")

    .exec(http(requestName="Get All Posts")
     .get("/posts")
    .check(bodyString.saveAs(key = "responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }

    
    .exec(
        http("Update Employee")
        .post("/posts")
        .headers(Map(
                        "User-Agent" -> "Safari/602.1",
                        "Content-Type" -> "application/json"
                        )
                    )
       .body(StringBody(content))
       .check(status.is(200)))

    .exec(http(requestName="Get Comments")
     .get("/comments")
    .check(bodyString.saveAs(key = "responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }

     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

    //val price = System.getProperty("price")
    //printf("<price>%s</price>",price)
    //val bodyFile = "./src/test/scala/sample.json"
    //val content = Source.fromFile(bodyFile).getLines.mkString
    //printf("%s",content)

}

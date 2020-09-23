import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source
import io.gatling.core.body.Body
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

class ServiceFramework extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000")
   var endpoint = System.getProperty("ENDPOINT","/posts")
   val method = System.getProperty("METHOD","GET")
   val transaction_name = System.getProperty("TRANSACTION_NAME","Dummy Get Request")
   val users = System.getProperty("USERS","1").toInt
   val headers = System.getProperty("HEADERS").replaceAll("[\n\r]", "").replaceAll("\"","")
   val csvfeeder = csv(fileName = "./src/test/resources/data/body.csv")
   val bodyparams = System.getProperty("BODYPARAMS","{}")

   println("URL : %s",url)
   println("ENDPOINT : %s",endpoint)
   println("METHODS : %s",method)
   println("TRANSACTION_NAME : %s",transaction_name)
   println("Headers : %s",headers)

   def svfPostAPI() :ChainBuilder = {
    feed(csvfeeder)
    .exec(http(requestName=transaction_name)
    .post(endpoint)
    .headers(headersParse)
    .body(StringBody(body)).asJson
    .check(bodyString.saveAs(key = "responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }  
   }

   def svfGetAPI() = {
       exec(http(requestName=transaction_name)
            .get(endpoint)
            .headers(headersParse)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
   }

  val scn = scenario("Service Framework")
   .doIfEquals(method, "GET")
           {
               exec(svfGetAPI())

           }
    .doIfEquals(method, "POST")  
           {
                exec(svfPostAPI())
           }

    setUp(scn.inject(atOnceUsers(users)).protocols(httpProtocol))
}
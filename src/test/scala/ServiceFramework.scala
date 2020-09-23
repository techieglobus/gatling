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
   val datafile = System.getProperty("DATAFILE","./src/test/resources/data/body.csv")
   val csvfeeder = csv(fileName = datafile)
   val bodyparams = System.getProperty("BODYPARAMS","{\"key\" : \"value\"}")
   val headersParse = headers.split(",").map(_.split("->")).map(arr => arr(0) -> arr(1)).toMap
   val httpProtocol = http.baseUrl(url)

   println("URL : ",url)
   println("ENDPOINT : ",endpoint)
   println("METHODS : ",method)
   println("TRANSACTION_NAME : ",transaction_name)
   println("Headers : ",headers)
   println("Parsed Headers : ",headersParse)
   println("BODY PARAMS : ",bodyparams)

   def svfPostAPI() :ChainBuilder = {
    feed(csvfeeder)
    .exec(http(requestName=transaction_name)
    .post(endpoint)
    .headers(headersParse)
    .body(StringBody(bodyparams)).asJson
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
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source
import io.gatling.core.body.Body
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

class ServiceFramework1 extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000")
   var endpoint = System.getProperty("ENDPOINT","/posts")
   val method = System.getProperty("METHOD","GET")
   val transaction_name = System.getProperty("TRANSACTION_NAME","Dummy Get Request")
   val users = System.getProperty("USERS","1").toInt
   val headers = System.getProperty("HEADERS").replaceAll("[\n\r]", "").replaceAll("\"","")
   //val datafile = System.getProperty("DATAFILE","./src/test/resources/data/body.csv")
   val csvfeeder = csv(fileName = "./src/test/resources/data/data.csv").circular
   val queryfeeder = csv(fileName = "./src/test/resources/data/query.csv").circular
   //val bodyparams = System.getProperty("BODYPARAMS","{\"key\" : \"value\"}")
   val bodyparamsfile  = "./src/test/resources/data/bodyparams.dat"
   val bodyparams = Source.fromFile(bodyparamsfile).getLines.mkString.replaceAll("[\n\r]", "")
   val queryparamsfile = "./src/test/resources/data/queryparams.dat"
   val queryparams = Source.fromFile(queryparamsfile).getLines.mkString.replaceAll("[\n\r]", "")
   val headersParse = headers.split(",").map(_.split(":")).map(arr => arr(0) -> arr(1)).toMap
   val httpProtocol = http.baseUrl(url)
   //val queryparams = System.getProperty("QUERYPARAMS","\"key\"->\"value\"")
   //val querymap = queryparams.split(",").map(_.split("->")).map(arr => arr(0) -> arr(1)).toMap

   println("URL : ",url)
   println("ENDPOINT : ",endpoint)
   println("METHODS : ",method)
   println("TRANSACTION_NAME : ",transaction_name)
   //println("Headers : ",headers)
   //println("Parsed Headers : ",headersParse)
   println("BODY PARAMS : ",bodyparams)
   println("QUERY PARAMS : ",queryparams) 
   //println("QUERY PARAMS Map : ",querymap)  

   def svfPostAPI() :ChainBuilder = {
    feed(csvfeeder)
    .feed(queryfeeder)
    .exec(http(requestName=transaction_name)
    .post(endpoint+queryparams)
    .headers(headersParse)
    .body(StringBody(bodyparams)).asJson
    .check(bodyString.saveAs(key = "responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }  

   }


   def svfGetAPI() = {
       feed(queryfeeder)
       .exec(http(requestName=transaction_name)
            .get(endpoint+queryparams)
            .headers(headersParse)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
   }


def svfPutAPI() :ChainBuilder = {
    feed(csvfeeder)
    .feed(queryfeeder)
    .exec(http(requestName=transaction_name)
    .put(endpoint+queryparams)
    .headers(headersParse)
    .body(StringBody(bodyparams)).asJson
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
     .doIfEquals(method, "PUT")  
           {
                exec(svfPutAPI())
           }      

    setUp(scn.inject(atOnceUsers(users)).protocols(httpProtocol))
    //setUp(scn.inject(incrementUsersPerSec((nbUsers*1).toInt) during(rampUsers((nbUsers*0.2).toInt) during(60 seconds)) separatedBy(600 seconds)))
}
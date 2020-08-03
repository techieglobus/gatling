import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class JMDAPI extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000/posts")
   val methods = System.getProperty("METHODS","GET")
   val transaction_name = System.getProperty("TRANSACTION_NAME","GET_ALL_POSTS")
   val users = System.getProperty("USERS","1")
   val headersJson = "./src/test/scala/headers.json"
   val headers = Source.fromFile(headersJson).getLines.mkString

   val httpProtocol = http.baseUrl(url)

   val scn = scenario("Test APIs")
     .doSwitch(transaction_name)( 
       "GET_ALL_POSTS" -> exec(
           doIfEquals(methods, "GET")
           {
             exec(http(requestName=transaction_name)
            .get(url)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
             }
           ),
        "GET_POST" -> exec(
           doIfEquals(methods, "GET")
           {
             exec(http(requestName=transaction_name)
            .get("/posts/1")
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
             }
           )
       )
     
     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}

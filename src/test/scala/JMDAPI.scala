import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class JMDAPI extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000")
   var endpoint = System.getProperty("ENDPOINT","/posts")
   val methods = System.getProperty("METHODS","GET")
   val transaction_name = System.getProperty("TRANSACTION_NAME","GET_ALL_POSTS")
   val users = System.getProperty("USERS","1")
   val headersData = "./src/test/scala/headers.dat"
   val headers = Source.fromFile(headersData).getLines.mkString
   val bodyData = "./src/test/scala/body.dat"
   val body = Source.fromFile(bodyData).getLines.mkString

   val httpProtocol = http.baseUrl(url)

   val scn = scenario("Test APIs")
     .doSwitch(transaction_name)( 
       "GET_ALL_POSTS" -> exec(
           doIfEquals(methods, "GET")
           {
             exec(http(requestName=transaction_name)
            .get(endpoint)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
             }
           ),
        "GET_POST" -> exec(
           doIfEquals(methods, "GET")
           {
             exec(http(requestName=transaction_name)
            .get(endpoint)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
             }
           ),
          "CREATE_POST" -> exec(
           doIfEquals(methods, "POST")
           {
             exec(http(requestName=transaction_name)
            .post(endpoint)
            .headers(Map(headers))
            .body(StringBody(body))
            .check(status.is(200)))
             }
          )
       )
     
     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}

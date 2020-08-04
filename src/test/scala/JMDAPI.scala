import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source
import io.gatling.core.body.Body

class JMDAPI extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000")
   var endpoint = System.getProperty("ENDPOINT","/posts")
   val methods = System.getProperty("METHODS","POST")
   val transaction_name = System.getProperty("TRANSACTION_NAME","GET_ALL_POSTS")
   val users = System.getProperty("USERS","1")
   val headersData = "./src/test/scala/headers.dat"
   val headers = Source.fromFile(headersData).getLines.mkString.replaceAll("[\n\r]", "")
   val bodyData = "./src/test/scala/body.dat"
   val body = Source.fromFile(bodyData).getLines.mkString
   val httpProtocol = http.baseUrl(url)
   val headersParse = headers.split(",").map(_.split("->")).map(arr => arr(0) -> arr(1)).toMap
   //val tmp = headers.split(",")
   //val tmp2 = tmp.map(_.split("->")).map(arr => arr(0) -> arr(1)).toMap
    println(headersParse)
    printf("URL : %s",url)
    printf("ENDPOINT : %s",endpoint)
    printf("METHODS : %s",methods)
    printf("TRANSACTION_NAME : %s",transaction_name)
    printf("USERS : %s",users)

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
            .headers(headersParse)
             .body(StringBody(body))
            .check(status.is(201)))
             }
          )
       )  
     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}

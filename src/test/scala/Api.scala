import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source
import io.gatling.core.body.Body
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

class BlogApiTesting extends Simulation {
     
   val url = System.getProperty("URL","http://localhost:3000")
   var endpoint = System.getProperty("ENDPOINT","/posts")
   val method = System.getProperty("METHOD","GET")
   val transaction_name = System.getProperty("TRANSACTION_NAME","GET_ALL_POSTS")
   val users = System.getProperty("USERS","1").toInt
   //val headersData = "./src/test/resources/data/services/headers.dat"
   val headers = System.getProperty("HEADERS").replaceAll("[\n\r]", "").replaceAll("\"","")
   println(headers)
   println(headers.getClass)
   //val headers = Source.fromFile(headersData).getLines.mkString.replaceAll("[\n\r]", "")
   val csvfeeder = csv(fileName = "./src/test/resources/data/services/body.csv")
  // val bodyData = "mavenscripts/src/test/resources/data/services/body.dat"
//   val body = Source.fromFile(bodyData).getLines.mkString
   val httpProtocol = http.baseUrl(url)
   val headersParse = headers.split(",").map(_.split("->")).map(arr => arr(0) -> arr(1)).toMap

   println(headersParse)
   printf("URL : %s",url)
   printf("ENDPOINT : %s",endpoint)
   printf("METHODS : %s",method)
   printf("TRANSACTION_NAME : %s",transaction_name)
  // printf("USERS : %s",users)


   def postReq() :ChainBuilder = {
    feed(csvfeeder)
    .exec(http(requestName=transaction_name)
    .post(endpoint)
    .headers(headersParse)
           // .body(StringBody("""  | {"name":"${name}","job": "${value}"}""".stripMargin)).asJson
    .body(StringBody("""{"quantity":"${quantity}","type":"ReceivingQuantityConsumption","order-line":{"id":"${order_line_ID}","line-num":"${line_num}","order-header-id":"${order_header_id}"}}""")).asJson
    .check(bodyString.saveAs(key = "responseBody")))
    .exec { session => println(session("responseBody").as[String]); session }  
      //.body(StringBody(body))
            //.check(status.is(201)))
   }

   val scn = scenario("Service_Testing")

           .doIfEquals(method, "GET")
           {
             exec(http(requestName=transaction_name)
            .get(endpoint)
            .headers(headersParse)
            .check(bodyString.saveAs(key = "responseBody")))
            .exec { session => println(session("responseBody").as[String]); session }
             }

           .doIfEquals(method, "POST")  
           {
             
             exec(postReq())
          //   exec(http(requestName=transaction_name)
           // .post(endpoint)
            //.headers(headersParse)
           // .body(StringBody("""  | {"name":"${name}","job": "${value}"}""".stripMargin)).asJson
            //.body(StringBody("""{"quantity":"${quantity}","type":"ReceivingQuantityConsumption","order-line":{"id":"${order_line_ID}","line-num":"${line_num}","order-header-id":"${order_header_id}"}}""")).asJson       
             //.body(StringBody(body))
            //.check(status.is(201)))
             }

         setUp(scn.inject(atOnceUsers(users)).protocols(httpProtocol))

}

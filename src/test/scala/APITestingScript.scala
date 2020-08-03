import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class APITestingScript extends Simulation {
  
    val url = System.getProperty("URL","http://localhost/")
    val methods = System.getProperty("METHODS","GET")
    val transaction_name = System.getProperty("TRANSACTION_NAME","GET ALL EMPLOYEE")
    val users = System.getProperty("USERS","1")

    val httpProtocol = http.baseUrl(url)
    val bodyJson = "./src/test/scala/body.json"
    val headersJson = "./src/test/scala/headers.json"
    val body = Source.fromFile(bodyJson).getLines.mkString
    val headers = Source.fromFile(headersJson).getLines.mkString
    
   

    val transactions = Map("GET_ALL_POSTS" -> "/posts", "GET_POST" -> "/posts/${post_id}", "CREATE_POST" -> "/posts")
    printf("URL : %s",url)
    printf("METHODS : %s",methods)
    printf("HEADERS : %s",headers)
    printf("TRANSACTION_NAME : %s",transaction_name)
    printf("USERS : %s",users)
    if ( transactions.contains(transaction_name) ) {
           println("Found Transaction: ",transaction_name,"URL: ",transactions(transaction_name))
           val transaction_url = transactions(transaction_name)
       }
   else
       {
          println("No Transaction Found with name : ",transaction_name)
          System.exit(0)
       }

    
   //  .feed(transaction_url)
    // .exec {
     //   session => session.set("transaction_url", "${transaction_url}")
     //}
     val scn = scenario(scenarioName="Performance Monitoring Automation")
     .doIfEquals(methods, "GET")
        {
        exec(http(requestName=transaction_name)
        .get("${transaction_url}")
        .check(bodyString.saveAs(key = "responseBody")))
        .exec { session => println(session("responseBody").as[String]); session }
        }
     
     setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}

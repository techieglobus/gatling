import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class APITestingScript extends Simulation {
  
    val url = System.getProperty("URL")
    val methods = System.getProperty("METHODS")
    val headers = System.getProperty("HEADERS")
    val transaction_name = System.getProperty("TRANSACTION_NAME")
    val users = System.getProperty("USERS")

    printf("URL : %s",url)
    printf("METHODS : %s",methods)
    printf("HEADERS : %s",headers)
    printf("TRANSACTION_NAME : %s",transaction_name)
    printf("USERS : %s",users)
    
}

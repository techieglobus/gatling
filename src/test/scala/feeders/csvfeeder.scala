
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source
import io.gatling.core.body.Body
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

class csvfeeder extends Simulation {
  
    val httpProtocol = http.baseUrl(url = "http://localhost:3000")
       .acceptHeader( value = "application/json").header(name="Content-Type",value="application/json")

    //define feeder

    val csvfeeder = csv(fileName = "data/sampledata.csv")

    //de createUser() : ChainBuilder
    def createUser()  :ChainBuilder = {
        feed(csvfeeder)
        .exec(http(requestName = "create a user")
         .post(url ="/posts")
         .body(StringBody("""
           | {"name":"${name}","job": "${value}"}
         """.stripMargin
         )).asJson.check(status.is(201)) )
    }

   val scn = scenario(scenarioName = "create mutiple users")
   .exec(createUser())

   setUp(scn.inject(atOnceUsers(users = 3))
   .protocols(httpProtocol))

}

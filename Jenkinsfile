pipeline {
    agent any
    stages {
        stage('File Upload') {
            steps {
          writeFile file: './src/test/scala/sample.json', text: params.BODY
           }
        }
        stage("Build Maven") {
            steps {
               bat '''mvn clean package'''
            }
        }
        
        stage("Run Gatling") {
            steps {
               bat  '''mvn gatling:test -Dgatling.simulationClass=APITestingScript -Durl="%URL%" -Dmethods="%METHODS%" -Dheaders=%HEADERS% -Dtransaction_name=%TRANSACTION_NAME% -Dusers=%USERS%'''
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
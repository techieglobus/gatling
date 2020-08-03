pipeline {
    agent any
    stages {
        stage('Upload Request Body') {
            steps {
          writeFile file: './src/test/scala/sample.json', text: params.BODY
           }
        }
        stage('Upload Request Headers') {
            steps {
          writeFile file: './src/test/scala/headers.json', text: params.HEADERS
           }
        }
        stage("Build Maven") {
            steps {
               bat '''mvn clean package'''
            }
        }
        
        stage("Run Gatling") {
            steps {
               bat  '''mvn gatling:test -Dgatling.simulationClass=APITestingScript -Durl="%URL%" -Dmethods="%METHODS%" -Dtransaction_name=%TRANSACTION_NAME% -Dusers=%USERS%'''
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
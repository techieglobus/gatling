pipeline {
    agent any
    stages {
        stage('echo body') {
            steps {
                bat '''echo %BODY%'''
            }
        }
        stage('Upload Request Body') {
            steps {
          writeFile file: './src/test/scala/body.dat', text: params.BODY
           }
        }
        stage('Upload Request Headers') {
            steps {
          writeFile file: './src/test/scala/headers.dat', text: params.HEADERS
           }
        }
        stage("Build Maven") {
            steps {
               bat '''mvn clean package'''
            }
        }
        
        stage("Run Gatling") {
            steps {
               bat  '''mvn gatling:test -Dgatling.simulationClass=JMDAPI -DURL="%URL%" -DMETHOD="%METHOD%" -DTRANSACTION_NAME=%TRANSACTION_NAME% -DUSERS=%USERS% -DENDPOINT=%ENDPOINT%'''
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
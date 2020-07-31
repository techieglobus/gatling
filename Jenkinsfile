pipeline {
    agent any
    stages {
        stage('File Upload') {
            steps {
          writeFile file: 'sample1.json', text: params.REQ_BODY
           }
        }
        stage("Build Maven") {
            steps {
               bat '''mvn clean package'''
            }
        }
        
        stage("Run Gatling") {
            steps {
               bat  '''mvn gatling:test -Dprice="%price%"'''
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
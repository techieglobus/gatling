pipeline {
    agent any
    stages {
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
pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                mvn clean package
            }
        }
        stage("Run Gatling") {
            steps {
                mvn gatling:test
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}
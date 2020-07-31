pipeline {
    agent any
    stages {
        stage("Upload File") {
            steps {
                def inputFile = input message: 'Upload file', parameters: [file(name: 'sample1.json')]
                  new hudson.FilePath(new File("$workspace/sample1.json")).copyFrom(inputFile)
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
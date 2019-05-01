pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {

                 steps {
                  script {
                            scannerHome = tool 'SonarQubeScanner'
                   }
                    withSonarQubeEnv('SonarQubeServer') {
                      sh 'sonar:sonar'
                    }
                  }
      }
      stage('Deployment') {
        steps {
            sh 'mvn tomcat7:deploy -e'
        }
      }
  }
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
}

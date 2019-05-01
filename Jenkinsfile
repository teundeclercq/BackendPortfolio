pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {
            tools {
                    sonarQube 'SonarQubeScanner'
                  }
                  steps {
                    withSonarQubeEnv('SonarQubeServer') {
                      sh 'mvn sonar:sonar'
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

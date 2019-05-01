pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {
               steps {
                 withSonarQubeEnv('SonarQubeScanner') {
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
    sonarQube 'SonarQubeScanner'
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
}

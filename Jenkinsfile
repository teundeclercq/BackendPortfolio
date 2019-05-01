pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {
            tools {
              sonarQube 'SonarQube Scanner 3.2'
            }
            steps {
              withSonarQubeEnv('SonarQube Scanner') {
                sh 'sonar-scanner'
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

pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {
         steps {
             script {
                scannerHome = tool 'SonarQubeScanner'
             }
             withSonarQubeEnv('SonarQube Scanner') {
                sh "mvn sonar:sonar \
                      -Dsonar.host.url=https://sonarqube.teun-school.nl \
                      -Dsonar.login=12af8009851a6984c1e69ef2212068c1361761f5"
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

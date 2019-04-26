pipeline {
  agent any
  stages {
    stage('Sonarqube') {
        environment {
            scannerHome = tool 'SonarQubeScanner'
        }
        steps {
            withSonarQubeEnv('sonarqube') {
                sh "${scannerHome}/bin/sonar-scanner"
            }
            timeout(time: 10, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
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

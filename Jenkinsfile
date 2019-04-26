pipeline {
  agent any
  stages {
    stage('Sonarqube') {
        steps {
            sh 'sonar-scanner -D sonar.login=eaf66e3e1e8f30a8ebecd2376df679464d91dccb'
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

pipeline {
  agent any
  stages {
    stage('Deployment') {
      steps {
        sh 'mvn tomcat:deploy'
      }
    }
  }
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
}
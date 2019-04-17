pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
  stages {
    stage('Deployment') {
      steps {
        sh 'mvn tomcat7:deploy'
      }
    }
  }
  
}

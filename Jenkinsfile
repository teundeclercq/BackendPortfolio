pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Deployment') {
      steps {
        sh 'mvn tomcat:deploy'
      }
    }
  }
}
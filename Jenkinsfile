pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        sh '''sh \'\'\'echo "PATH = ${PATH}"
      echo "M2_HOME = ${M2_HOME}"\'\'\' '''
      }
    }
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
  environment {
    maven = 'Maven 3.3.9'
    jdk = 'jdk11'
  }
}
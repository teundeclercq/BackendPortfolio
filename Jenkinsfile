pipeline {
  agent any
  stages {
    stage('Sonarqube') {
        steps {
            sh 'mvn clean install sonar:sonar JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java"'
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

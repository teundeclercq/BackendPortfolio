pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
  stages {
      stage('Compile') {
        steps {
          sh 'mvn clean install'
        }
      }
      stage('SonarQube analysis') {
        steps {
          withSonarQubeEnv('sonar-6') {
            sh 'mvn sonar:sonar -e'
          }
        }
      }
      stage('Deployment') {
        steps {
            sh 'mvn tomcat7:deploy -e'
        }
      }
  }
}

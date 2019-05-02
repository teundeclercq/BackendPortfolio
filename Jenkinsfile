pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
  stages {
      stage('Compile') {
        steps {
          sh 'mvn clean install package'
        }
      }
      stage('SonarQube analysis') {
        steps {

            sh 'mvn sonar:sonar'

        }
      }
      stage('Deployment') {
        steps {
            sh 'mvn tomcat7:deploy -e'
        }
      }
  }
}

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

            sh 'mvn sonar:sonar -Dsonar.login=57914a907d8d32a2954f765b15a9d279e4215355'

        }
      }
      stage('Deployment') {
        steps {
            sh 'mvn tomcat7:deploy -e'
        }
      }
  }
}

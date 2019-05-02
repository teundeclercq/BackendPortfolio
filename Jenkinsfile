pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
  stages {
      stage('SonarQube analysis') {
        steps {
          withSonarQubeEnv('sonar-6') {
            sh 'sonar-scanner -D sonar.login=57914a907d8d32a2954f765b15a9d279e4215355'
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

pipeline {
  agent any
  tools {
    maven 'Maven 3.3.9'
    jdk 'jdk11'
  }
  stages {
      stage('Compile Package') {
        sh '${maven}/bin/mvn package'
      }
      stage('SonarQube analysis') {
        steps {
          withSonarQubeEnv('sonar-6') {
            sh '${maven}/bin/mvn sonar:sonar'
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

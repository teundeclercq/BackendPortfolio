pipeline {
  agent any
  stages {
    stage('Sonarqubescanner') {
       steps {
            mvn sonar:sonar -Dsonar.host.url=https://sonarqube.teun-school.nl -Dsonar.login=005e7fab1a20bcea8b24c26c76c8358df702b0bd
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

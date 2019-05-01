pipeline {
  agent any
  stages {
      stage('SonarQube analysis') {
         steps {
                    script {
                      // requires SonarQube Scanner 2.8+
                      scannerHome = tool 'SonarQube Scanner 2.8'
                    }
                    withSonarQubeEnv('SonarQube Scanner') {
                      sh "${scannerHome}/bin/sonar-scanner"
                    }
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

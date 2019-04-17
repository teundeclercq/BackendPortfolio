pipeline {
   agent any
   tools {
        maven 'Maven 3.3.9'
        jdk 'jdk11'
   }
   stages {
     stage('Initialize') {
        steps {
            git credentialsId: '0b90389f-5ed6-4f37-8478-83a4d155e14a', url: 'https://github.com/teundeclercq/BackendPortfolio.git'
        }
     }
     stage('Compile-Package') {
        steps {

            sh "mvn package"
        }

     }
   }

}


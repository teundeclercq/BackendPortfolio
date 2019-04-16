node {
   stage('SCM Checkout') {

        git credentialsId: '0b90389f-5ed6-4f37-8478-83a4d155e14a', url: 'https://github.com/teundeclercq/BackendPortfolio.git'
   }
   stage('Compile-Package') {
        // Get maven home path
        def mvnHome = tool name: 'maven-3', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
   }
}


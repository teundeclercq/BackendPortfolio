node {
   stage('SCM Checkout') {
        git 'https://github.com/teundeclercq/BackendPortfolio.git'
   }
   stage('Compile-Package') {
        sh 'mvn package'
   }
}


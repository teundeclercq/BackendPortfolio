pipeline {
agent any&lt;/code&gt;

tools{
maven 'maven 3.3.9'
jdk 'java 11'
}

stages {
stage ("initialize") {
steps {
sh '''
echo "PATH = ${PATH}"
echo "M2_HOME = ${M2_HOME}"
'''
}
}

pipeline {
    agent { 
       label 'agent2'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
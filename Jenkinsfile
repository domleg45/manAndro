pipeline {
    agent { 
       label 'agent1'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
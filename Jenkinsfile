pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: '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', url: 'https://github.com/ajaygaddam91/cerebrone.git'
            }
        }
        stage('AddMvn'){
            steps{
                sh 'export M2_HOME=/opt/maven'
                sh 'export M2=$M2_HOME/bin'
                sh 'export PATH=$PATH:$M2'
            }
        }
        stage('CheckVersion'){
            steps{
                sh 'mvn --version'
            }
        }
        stage('Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Validate'){
            steps{
                sh 'mvn validate'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn package -DskipTests'    
            }
        }
        stage('Deploy'){
            steps{
                sh 'mvn deploy -DskipTests'
            }
        }
    }
}

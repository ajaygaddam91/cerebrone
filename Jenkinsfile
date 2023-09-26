pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'zoheb', credentialsId: 'b3deed1b-58f4-4b84-b11d-a09754281597', url: 'https://github.com/cerebrone-ai/Cerebrone-training.git'
            }
        }
        stage('AddMvn'){
            steps{
                sh 'export M2_HOME=/opt/apache-maven-3.9.2'
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

pipeline {
    agent any
    environment{
        PATH = "/opt/maven/bin:$PATH"
    }
    tools {
        maven 'maven'
    }
    stages{
      stage('Git checkout'){
        steps{
            git branch: 'master', credentialsId: 'f09c4bdf-ccb7-4a5a-9ad0-749b96567ad2', url: 'https://github.com/ajaygaddam91/cerebrone.git'
        }
      }
      stage('maven version'){
        steps{
	  sh 'mvn --version'
	  }
	  }
      stage('maven build'){
          steps{
              sh 'mvn clean package -DskipTests'
          }
      }
      stage('Nexus deploy'){
          steps{
              sh 'mvn deploy -DskipTests'
          }
      }      
      }
      }
    


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
      stage('maven build'){
          steps{
              sh 'mvn clean package -DskipTests'
          }
      }
      stage('Nexus deploy'){
          steps{
          script{
            
            def mavenPom = readMavenPom file: 'pom.xml'
            def nexusRepoName = mavenPom.version.endsWith("SNAPSHOT") ? "first-snapshot" : "first-repo"
             nexusArtifactUploader artifacts: [
                 [
                     artifactId: 'spring-boot-crud-example', 
                     classifier: '', 
                     file: "target/spring-boot-crud-example-${mavenPom.version}.jar",
                     type: 'jar'
                     ]
                     ],
                     credentialsId: 'nexus',
                     groupId: 'com.cerebrone', 
                     nexusUrl: '44.205.246.59:8081/', 
                     nexusVersion: 'nexus3',
                     protocol: 'http',
                     repository: nexusRepoName,
                     version: "${mavenPom.version}"
          }
          }
      }      
      }
      }
    

    


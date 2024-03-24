pipeline{
   agent any
   tools{
      maven "Maven"
   }
   stages{
      stage("Checkout from git and build project"){
         steps{
            checkout scmGit(branches: [[name: '*/server']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/VinDeAlone/Exel-test']])
            powershell "mvn clean install"
         }
      }
      stage("build docker image"){
         steps{
            powershell "docker build -t vindealone/exeltestimage:0.0.1 ."
         }
      }
      stage("push image to docker hub"){
         steps{
            withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerpwd')]) {
               powershell "docker login -u vindealone -p ${dockerpwd}"
            }
            powershell "docker push vindealone/exeltestimage:0.0.1"
         }
      }
   }
}
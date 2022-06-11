pipeline {
    agent any
    stages {
        stage('BUILD') {
            steps {
                      git 'https://github.com/avietlobo/api-assignment-project.git'
                      bat label: '', script: 'mvn clean'
            }
        }
    stage('TEST') {
           steps {
             bat label: '', script: 'mvn test'
        } 
       
   }

}
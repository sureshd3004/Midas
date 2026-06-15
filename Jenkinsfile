pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile' 
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    // Archive TestNG results
                    testng(pattern: '**/test-output/testng-results.xml')
                }
            }
        }
    }
}
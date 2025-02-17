pipeline {
    agent any

    environment {
        BROWSER = "chrome"  // Set default browser
    }

    stages {
        stage('Checkout Developer Code') {
            steps {
<<<<<<< HEAD
                git branch: 'main', url: 'https://bitbucket.org/your-project/developer-repo.git'
=======
                git branch: 'main', url: 'https://sureshd3@bitbucket.org/infoplus-mdm-dev/midas-version-2.0-automation.git'
>>>>>>> 52f96a3 (updated code)
            }
        }

        stage('Checkout Selenium Tests') {
            steps {
<<<<<<< HEAD
                git branch: 'main', url: 'https://sureshd3@bitbucket.org/infoplus-mdm-dev/midas-version-2.0-automation.git', changelog: false, poll: false
=======
                git branch: 'main', url: 'https://sureshd3@bitbucket.org/infoplus-mdm-dev/midas.git', changelog: false, poll: false
>>>>>>> 52f96a3 (updated code)
            }
        }

        stage('Setup Dependencies') {
            steps {
                script {
                    sh 'mvn clean install'  // Install dependencies
                }
            }
        }

        stage('Run Selenium Tests') {
            steps {
                script {
                    sh 'mvn test'  // Runs the Selenium tests
                }
            }
        }

        stage('Generate Test Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'  // JUnit/TestNG results
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/screenshots/*.png', fingerprint: true
        }
        failure {
            echo 'Tests failed! Check the logs.'
        }
    }
}

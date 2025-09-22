pipeline {
    agent any

    tools {
        jdk 'JDK11'      // Ensure this matches the JDK name in Jenkins
        maven 'Maven3'   // Ensure this matches the Maven name in Jenkins
    }

    environment {
        PROJECT_REPO = 'https://github.com/mahii47/YouTubeAutomation.git'
        BRANCH = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH}", url: "${PROJECT_REPO}"
            }
        }

        stage('Build & Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'YouTubeData.txt', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}

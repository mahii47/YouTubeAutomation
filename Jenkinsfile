pipeline {
    agent any

    tools {
        maven 'Maven'    // Make sure Maven is configured in Jenkins
        jdk 'JDK11'      // Make sure JDK11 is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mahii47/YouTubeAutomation.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/cucumber-reports/*.html', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }

        success {
            echo "Build and Tests Passed!"
        }

        failure {
            echo "Build or Tests Failed!"
        }
    }
}

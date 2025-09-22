pipeline {
    agent any

    environment {
        // Make sure this Maven installation exists in Jenkins Global Tool Configuration
        MAVEN_HOME = tool name: 'Maven 3.9.3', type: 'maven'
        JAVA_HOME = tool name: 'JDK 11', type: 'jdk'
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mahii47/YouTubeAutomation.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    // Run Maven clean and test
                    sh 'mvn clean test'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                script {
                    // Archive XML and HTML if they exist, but don't fail if they don't
                    archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
                    archiveArtifacts artifacts: '**/target/cucumber-reports/*.html', allowEmptyArchive: true
                }
            }
        }
    }

    post {
        always {
            // Wrap workspace cleanup inside node to avoid errors
            node {
                echo 'Cleaning up workspace...'
                cleanWs()
            }
        }
        failure {
            echo 'Build or tests failed!'
        }
        success {
            echo 'Build and tests completed successfully!'
        }
    }
}

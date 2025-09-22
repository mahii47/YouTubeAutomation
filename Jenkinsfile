pipeline {
    agent any

    environment {
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
                sh 'mvn clean test'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive XML and HTML reports, don't fail if empty
                archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: '**/target/cucumber-reports/*.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        failure {
            echo 'Build or tests failed!'
        }
        success {
            echo 'Build and tests completed successfully!'
        }
    }
}

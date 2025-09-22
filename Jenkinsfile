pipeline {
    agent any

    tools {
        jdk 'JDK11'        // your Jenkins JDK tool name
        maven 'Maven3'     // your Jenkins Maven tool name
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/mahii47/YouTubeAutomation', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}

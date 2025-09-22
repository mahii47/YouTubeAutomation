pipeline {
    agent any

    tools {
        jdk 'JDK11'        // Your Jenkins JDK installation
        maven 'Maven'      // Your Jenkins Maven installation
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
    }

    post {
        always {
            echo "Pipeline finished."
        }
    }
}

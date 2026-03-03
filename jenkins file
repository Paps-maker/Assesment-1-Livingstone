pipeline {
    agent any

    tools {
        jdk 'jdk21' 
        maven 'maven3' 
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling code from GitHub...'
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                dir('java_training') { 
                    echo 'Compiling Java source code...'
                    sh 'mvn clean compile' 
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('java_training') { 
                    echo 'Running Unit Tests (JUnit)...'
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('java_training') { 
                    echo ' Packaging application into a JAR file...'
                    sh 'mvn package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Tests passed successfully!'
        }
        failure {
            echo 'Build failed. Check the Console Output for errors.'
        }
    }
}

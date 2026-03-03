pipeline {
    agent any

    tools {
        // Uses the JDK 21 we set up with Adoptium
        jdk 'jdk21' 
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
                echo 'Compiling Java source code...'
                // Compiles all .java files found in the root directory
                sh 'javac *.java' 
            }
        }

        stage('Verify') {
            steps {
                echo 'Checking for compiled class files...'
                sh 'ls -l *.class'
            }
        }
    }

    post {
        success {
            echo 'Build passed successfully!'
        }
        failure {
            echo 'Build failed. Check the console output for syntax errors.'
        }
    }
}
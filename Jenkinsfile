pipeline {
    agent any

    environment {
        // Your Docker Hub username
        DOCKER_HUB_USER = 'stone00'
        // This must match the ID of the Secret Text credential you created in Jenkins
        DOCKER_HUB_PASS = credentials('docker-hub-password')
    }

    tools {
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
                sh 'javac *.java' 
            }
        }

        stage('Verify') {
            steps {
                echo 'Checking for compiled class files...'
                sh 'ls -l *.class'
            }
        }

        // --- NEW STAGES FOR QUESTION 2 ---

        stage('Package') {
            steps {
                echo 'Packaging classes into app.jar...'
                // Bundles your compiled classes into a JAR file
                sh 'jar cvf app.jar *.class'
            }
            post {
                success {
                    // This makes the JAR file downloadable from the Jenkins UI
                    archiveArtifacts artifacts: 'app.jar', fingerprint: true
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    echo "Building and Pushing Docker Image..."
                    // Builds the image using the Dockerfile in your folder
                    sh "docker build -t ${DOCKER_HUB_USER}/java-assessment:latest ."
                    
                    // Log in using the credentials we set up in Jenkins
                    sh "echo $DOCKER_HUB_PASS | docker login -u $DOCKER_HUB_USER --password-stdin"
                    
                    // Push the final image to your repository
                    sh "docker push ${DOCKER_HUB_USER}/java-assessment:latest"
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Docker Publish passed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
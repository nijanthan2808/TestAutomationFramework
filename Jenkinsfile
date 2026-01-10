pipeline {
    agent any

    options {
        timestamps()
        ansiColor('xterm')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw -B test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/extent-report/*.html', allowEmptyArchive: true
        }
    }
}

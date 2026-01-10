pipeline {
    agent any
    tools {
        jdk 'jdk17'
    }

    options {
        timestamps()
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
                script {
                    def testStatus = sh(script: './mvnw -B test', returnStatus: true)
                    def results = junit(testResults: 'target/surefire-reports/*.xml')
                    def total = results.totalCount
                    def failed = results.failCount
                    def skipped = results.skipCount
                    def passed = total - failed - skipped
                    def passRate = total == 0 ? 0 : (passed * 100.0 / total)
                    if (passRate < 75.0) {
                        error("Pass rate ${String.format('%.2f', passRate)}% is below 75%")
                    }
                    if (testStatus != 0) {
                        echo "Tests failed, but pass rate ${String.format('%.2f', passRate)}% is >= 75%."
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/extent-report/*.html', allowEmptyArchive: true
        }
    }
}

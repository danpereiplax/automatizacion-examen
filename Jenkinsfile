pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando proyecto Maven...'
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Ejecutando pruebas UNITARIAS (Surefire)...'
                bat 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                echo 'Ejecutando pruebas de INTEGRACIÓN (Failsafe)...'
                bat 'mvn -B failsafe:integration-test failsafe:verify'
            }
            post {
                always {
                    junit 'target/failsafe-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        success {
            echo 'Pipeline completada con éxito 🚀'
        }
        failure {
            echo 'La pipeline falló. Revisar logs y reportes de pruebas.'
        }
    }
}
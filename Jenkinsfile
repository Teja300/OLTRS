properties([
    pipelineTriggers([githubPush()])
])

node {

    stage('Checkout') {
        git branch: 'master',
            url: 'https://github.com/Teja300/OLTRS.git'
    }

    stage('Build') {
        bat 'mvn clean compile'
    }

    stage('Test') {
        bat 'mvn test'
    }

    stage('Package') {
        bat 'mvn package'
    }

    stage('Docker Build') {
        bat 'docker build -t pedhoda/oltrs:latest .'
    }

    stage('Docker Push') {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            bat '@echo off\r\necho %DOCKER_PASS%| docker login -u %DOCKER_USER% --password-stdin'

            try {
                bat 'docker push pedhoda/oltrs:latest'
            } finally {
                bat 'docker logout'
            }
        }
    }
}
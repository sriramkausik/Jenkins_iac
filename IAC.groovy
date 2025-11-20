pipeline {
    agent any
    
     tools {
        terraform 'Terraform' // This must match the name you configured in Jenkins
    }
    
    environment {
        // Set environment variables here if needed
        TF_WORKSPACE = 'default'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repo with Terraform code
                git url: 'https://github.com/sriramkausik/Ansible_Infra.git', branch: 'main'
            }
        }

        stage('Initialize Terraform') {
            steps {
                bat 'terraform init'
            }
        }

        stage('Validate Terraform') {
            steps {
                bat 'terraform validate'
            }
        }

        stage('Plan Terraform') {
            steps {
                bat 'terraform plan -out=tfplan'
            }
        }

        stage('Apply Terraform') {
            steps {
                input message: 'Approve infrastructure changes?'
                bat 'terraform apply tfplan'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }
    }
}

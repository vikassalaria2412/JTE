void call()
{
    stage('SonarQube: Static Code Analysis') {
        steps {
                script {
                    echo "SonarQube analysis"
                    def scannerHome = tool 'SonarQubeScanner'
                    withSonarQubeEnv('sonarserver') {
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=javasampleproject -Dsonar.host.url=http://52.201.237.207:9000 -Dsonar.sources=src -Dsonar.java.binaries=/home/jenkins/agent/workspace/vikas_test_pipeline_new/dmifactory/build -Dsonar.log" 
                    }           

            }

        }

        }
}
// Fetch code from svn repository
void call()
{
    stage('svn:code') {
           
                // Checkout code from SVN repository changes
                checkout([$class: 'SubversionSCM', 
                additionalCredentials: [], 
                excludedCommitMessages: '', 
                excludedRegions: '', 
                excludedRevprop: '', 
                excludedUsers: '', 
                filterChangelog: false, 
                ignoreDirPropChanges: false, 
                includedRegions: '', 
                locations: [[credentialsId: Svn.credential_id, 
                           depthOption: 'infinity', 
                           ignoreExternalsOption: true, 
                           remote: 'https://svn.riouxsvn.com/dmifactory']], 
                workspaceUpdater: [$class: 'UpdateUpdater']])
                script {
                    def currentDir = sh(returnStdout: true,script: 'pwd').trim()
                // Print current directory
                    echo "Current directory: ${currentDir}"
                // List contents of the current directory
                    sh "ls ${currentDir}"
                //var = echo 'Current directory: ' + pwd()
                    sh 'ls /home/jenkins/agent/workspace/vikas_test_pipeline_new/dmifactory'
                    
                }
                // Set the path to the build.xml file
                
            

        }
    
}
// Fetch code from svn repository
void call()
{
    stage('svn:code') {
        agent {
            label 'jenkins-slave' // Replace with the label of your Jenkins slave
    }
           
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
        echo "start"
        locations: [[credentialsId: 'svn_credential_pipeline', 
                    depthOption: 'infinity', 
                    ignoreExternalsOption: true, 
                    remote: 'https://svn.riouxsvn.com/dmifactory']],
        echo "end"
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
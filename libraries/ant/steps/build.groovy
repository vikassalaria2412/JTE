// write Jenkins Template Engine style groovy script here
void call()
{
    stage("Ant: build"){

        steps {
                script
                {
                    def buildXmlPath = "${env.WORKSPACE}/dmifactory/build.xml"
                    def buildXmlContent = readFile("${env.WORKSPACE}/dmifactory/build.xml")
                    echo "Build.xml Content:\n${buildXmlContent}"

                    withAnt(installation: 'Ant_Home')
                    {
					 //ant targets: 'clean compile target', buildFile: 'build.xml'
                     sh 'ant clean compile jspDeploy target war'

                        
                    }

                }
                }

    }
    }
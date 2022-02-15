node {

def mvnHome

stage('Prepare') {

git url: 'git@github.com:andesreenathreddy/new-devops-ci-cd-docker.git', branch: 'master'

mvnHome = tool 'maven'

}

stage('Build') {

if (isUnix()) {

sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"

} else {

bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)

}

}

stage('Unit Test') {

junit '**/target/surefire-reports/TEST-*.xml'

archive 'target/*.jar'

}

stage('Integration Test') {

if (isUnix()) {

sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"

} else {

bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)

}

}



stage('Sonar') {

if (isUnix()) {

sh "'${mvnHome}/bin/mvn' sonar:sonar"

} else {

bat(/"${mvnHome}\bin\mvn" sonar:sonar/)

}

}
stage('Dockerize App'){
	
	if (isUnix()) {


          
              sh "docker-compose build"
              sh "docker-compose up -d"
              
          
       

} else {


bat("docker-compose build")
bat("docker-compose up -d")


}
       
	
     
     }



stage('Publish') {

def server = Artifactory.server 'Artifactory'

def rtMaven = Artifactory.newMavenBuild()

rtMaven.tool = 'maven'

rtMaven.resolver server: server, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'

rtMaven.deployer server: server, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'

def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'install'

server.publishBuildInfo buildInfo

}





}

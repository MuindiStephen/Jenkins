pipeline {
  agent any
  environment {
    APP_NAME = 'SocialsApp'
    BUILD_VERSION = sh(script: ‘cat app/build.gradle | egrep -o \’versionName “(.*?)”\’ | cut -d \’ \’ -f 2- | tr -d \’”\’’, , returnStdout: true).trim()
    APP_ID = 'com.steve_md.socialsapp'
    BUILD_TYPE = ‘debug’
  }
  
  rtUpload (
  serverId: “Artifactory_1”,
  spec:
    “””{
      “files”: [
        {
          “pattern”: “*.aar”,
          “target”: “example-repo-local/teste-app/”
        }
      ]
    }”””
)
  
  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {
         
        // Detect
        stage('Detect build type') {
        steps {
          script {
            if (env.BRANCH_NAME == 'main' || env.CHANGE_TARGET == 'main') {
              env.BUILD_TYPE = 'debug'
            } else if (env.BRANCH_NAME == 'master' || env.CHANGE_TARGET == 'master') {
              env.BUILD_TYPE = 'release'
            }
          }
        }
      }
      
       // Compile
        stage('Compile') {
        steps {
          // Compile the app and its dependencies
          sh './gradlew compile${BUILD_TYPE}Sources'
        }
      }
      
      // Build
            stage('Build') {
            steps {
              // Compile the app and its dependencies
              sh './gradlew assemble${BUILD_TYPE}'
              sh './gradlew generatePomFileForLibraryPublication'
            }
          }
      
      // Publish
          stage('Publish') {
          steps {
            // Archive the APKs so that they can be downloaded from Jenkins
            archiveArtifacts "**/${APP_NAME}-${BUILD_TYPE}.apk"
            // Archive the ARR and POM so that they can be downloaded from Jenkins
            // archiveArtifacts "**/${APP_NAME}-${BUILD_TYPE}.aar, **/*pom-   default.xml*"
          }
          
          // Calling our app in the publishing stage
          SocialsApp (
          applications: [[
            downloadAllowed: true,
            filePath: “**/*.apk”,
            mandatory: false,
            notifyTeam: true,
            releaseNotesMethod: none(),
            uploadMethod: versionCreation(appId: ${APP_ID}, versionCode: '1.0.0')
          ]],
          baseUrl: ‘’,
          debugMode: false,
          failGracefully: false
           )
        }
      
  }
}

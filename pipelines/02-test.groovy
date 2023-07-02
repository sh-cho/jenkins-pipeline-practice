
void setBuildStatus(String message, String state) {
  step([
          $class: "GitHubCommitStatusSetter",
          reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/sh-cho/jenkins-pipeline-practice"],
          contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/build-status"],
          errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
          statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}

pipeline {
  agent {
    docker {
      image 'eclipse-temurin:17-jdk-centos7'
    }
  }

  parameters {
    // https://plugins.jenkins.io/git-parameter/
    gitParameter defaultValue: "main",
      branchFilter: "origin/(.*)",
      name: "BRANCH",
      type: "PT_BRANCH",
      description: "choose branch",
      sortMode: "DESCENDING_SMART",
      useRepository: "https://github.com/sh-cho/jenkins-pipeline-practice"
  }

  stages {
    stage("Test") {
      steps {
        sh label: "test!", script: "./gradlew test"
      }
    }

    stage("Build") {
      steps {
        sh label: "build", script: "./gradlew bootJar"
      }
    }
  }

  post {
    success {
      setBuildStatus("Build succeeded", "SUCCESS")
    }
    failure {
      setBuildStatus("Build failed", "FAILURE")
    }
  }
}

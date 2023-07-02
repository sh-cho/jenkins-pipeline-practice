pipeline {
  agent {
    docker {
      image 'eclipse-temurin:17-jdk-centos7'
    }
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
}

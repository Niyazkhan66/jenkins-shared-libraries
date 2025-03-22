def call(String CredId, String imageName, String imageTag){
  withCredentials([usernamePassword(credentialsId:CredId, passwordVariable:"dockerHubPass", usernameVariable:"dockerHubUser")]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
                    sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
                }
}

def call(Map params){
    sh """
        version=$(cat VERSION)
        docker build -t ${params.name} ${params.path}
        docker tag ${params.name} ${params.name}:\$version
        docker tag ${params.name} ${params.name}:${BUILD_NUMBER}
        docker images
    """
}
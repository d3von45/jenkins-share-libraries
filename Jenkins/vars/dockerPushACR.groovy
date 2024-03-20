def call(Map params){
    echo "==========================================="
    echo "Login ACR"
    echo "==========================================="

    sh "az acr login -n ${params.REGISTRY}"
    sh "docker push ${params.name}:${params.tag}"
    sh "docker push ${params.name}:${params.version}"

}
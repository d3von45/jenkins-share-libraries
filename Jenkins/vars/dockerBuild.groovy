def call(Map params){
    sh "docker build -t ${params.name} -f ${params.path} ."
    sh "docker tag ${params.name} ${params.name}:${params.version}"
    sh "docker tag ${params.name} ${params.name}:${params.tag}"
    sh "docker images"
}
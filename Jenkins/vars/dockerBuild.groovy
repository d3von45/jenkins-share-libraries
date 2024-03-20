def call(Map params){
    version = readFile('VERSION').replace("\n","").replace("\r", "")
    sh "docker build -t ${params.name} ${params.path}"
    sh "docker tag ${params.name} ${params.name}:${version}"
    sh "docker images"
}
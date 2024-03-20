def call(Map params){
    // Get version
    version = readFile('VERSION').replace("\n","").replace("\r", "")
    // Get short git commit
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")

    sh "docker build -t ${params.name} ${params.path}"
    sh "docker tag ${params.name} ${params.name}:${version}"
    sh "docker tag ${params.name} ${params.name}:${tag}"
    sh "docker images"
}
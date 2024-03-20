def call(){
    // Get version
    version = readFile('VERSION').replace("\n","").replace("\r", "")
    // Get short git commit
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
}
    
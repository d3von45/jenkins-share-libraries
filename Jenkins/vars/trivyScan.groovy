def call(Map params){
    TRIVY_VERSION = "0.50.0"
    // Get Trivy
    sh "curl -LO https://github.com/aquasecurity/trivy/releases/download/v0.50.0/trivy_${TRIVY_VERSION}_Linux-64bit.tar.gz"
    sh "tar -zxvf trivy_${TRIVY_VERSION}_Linux-64bit.tar.gz"
    // Scan all vuln levels
    sh 'ls'
    sh 'mkdir -p reports'
    sh "curl -LO https://raw.githubusercontent.com/aquasecurity/trivy/main/contrib/html.tpl"
    sh "./trivy image --format template --template @./html.tpl -o ./reports/report.html ${params.image}"

    publishHTML target : [
        allowMissing: true,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        reportDir: 'reports',
        reportFiles: 'report.html',
        reportName: 'Trivy Scan',
        reportTitles: 'Trivy Scan'
    ]
}
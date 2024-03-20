def call(Map params){

    sh "sed s/@@TAG@@/${params.tag}/" params.path | kubectl apply -f -

}
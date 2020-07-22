node{
    stage('SCM Checkout'){
     git 'https://github.com/ando7555/BookCatalog'
    }
    stage('Compile-Package'){
               def mvnHome = tool name: '', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
    }
}

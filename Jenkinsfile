node{
    stage('SCM Checkout'){
     git 'https://github.com/ando7555/BookCatalog.git'
    }
    stage('Compile-Package'){
      sh 'mvn package'
    }
}

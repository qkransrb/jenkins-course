job('NodeJS Example') {
    scm {
        git('git://github.com/qkransrb/express-server.git') { node ->
            node / gitConfigName('qkrasnrb')
            node / gitConfigEmail('qkransrb90@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS')
    }
    steps {
        shell('npm install')
    }
}
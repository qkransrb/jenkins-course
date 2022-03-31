job('NodeJS Docker Example') {
    scm {
        git('https://github.com/qkransrb/jenkins-course.git') { node ->
            node / gitConfigName('qkransrb')
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
        dockerBuildAndPublish {
            repositoryName('qkransrb90/docker-express-server')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
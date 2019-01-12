package de.rtg.test.ui.modules


import geb.Module

class PostModule extends Module {

    static content = {
        title { $('.qa-post-title').text() }
        postContent { $('.qa-post-content').text() }
    }

}

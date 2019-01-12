package de.rtg.test.ui.models


import static de.rtg.test.ui.utils.RandomHelper.someString

class Post {

    String id
    String author
    String title
    String content

    static Post createRandom() {
        return new Post(title: someString(), content: someString(50))
    }

}

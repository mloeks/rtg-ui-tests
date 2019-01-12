package de.rtg.test.ui


import de.rtg.test.ui.models.Post
import de.rtg.test.ui.pages.FoyerPage

import static de.rtg.test.ui.models.Post.createRandom

class FoyerSpec extends AbstractRtgSpec {

    def "a news post is visible"() {
        given:
        Post somePost = adminApiActor.addPost(createRandom())
        assert somePost

        when:
        FoyerPage foyer = to FoyerPage

        then:
        foyer.posts.size() == 1

        and:
        with(foyer.posts[0]) {
            verifyAll {
                title == somePost.title
                postContent == somePost.content
            }
        }

        cleanup:
        adminApiActor.deletePost(somePost)
    }

}
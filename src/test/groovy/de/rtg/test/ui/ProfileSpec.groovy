package de.rtg.test.ui


import de.rtg.test.ui.pages.ProfilePage

class ProfileSpec extends AbstractRtgSpec {

    def "a user can access their profile"() {
        when:
        userActor.goToProfile()

        then:
        waitFor { at ProfilePage }
    }

}
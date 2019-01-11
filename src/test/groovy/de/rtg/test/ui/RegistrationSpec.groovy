package de.rtg.test.ui

import de.rtg.test.ui.actors.UserActor

class RegistrationSpec extends AbstractRtgSpec {

    UserActor userActor

    def "a new user can register"() {
        given:
        userActor = new UserActor(browser)
                .withRegistered()

        expect:
        userActor

        cleanup:
        adminApiActor.deleteUser(userActor.user)
    }

}
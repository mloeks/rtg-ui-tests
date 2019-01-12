package de.rtg.test.ui

import de.rtg.test.ui.actors.UserActor

class RegistrationSpec extends AbstractRtgSpec {

    UserActor userActor

    def "a new user can register"() {
        given:
        userActor = new UserActor(browser)

        when:
        userActor.register()

        then:
        userActor

        cleanup:
        adminApiActor.deleteUser(userActor.user)
    }

}
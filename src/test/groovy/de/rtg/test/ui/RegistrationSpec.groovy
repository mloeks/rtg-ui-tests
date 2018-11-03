package de.rtg.test.ui

import de.rtg.test.ui.models.User
import de.rtg.test.ui.pages.FoyerPage
import de.rtg.test.ui.pages.ReceptionPage

class RegistrationSpec extends AbstractRtgSpec {

    def "reception is available"() {
        when:
        to ReceptionPage

        then:
        noExceptionThrown()
    }

    def "a new user can register"() {
        given:
        ReceptionPage receptionPage = to ReceptionPage
        User newUser = new User(username: 'test1234', firstName: 'Testy', lastName: 'McTestface',
                email: 'testy@mctestface.com', password: 'test1234')

        when:
        receptionPage.register(newUser)

        then:
        FoyerPage foyer = at FoyerPage

        and:
        foyer.loggedInUsername == newUser.username
        foyer.isFirstVisit()

//        cleanup:
        // TODO remove created test user
    }

}
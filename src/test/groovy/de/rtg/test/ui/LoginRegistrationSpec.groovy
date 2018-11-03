package de.rtg.test.ui

import de.rtg.test.ui.pages.ReceptionPage

class LoginRegistrationSpec extends AbstractRtgSpec {

    def "reception is available"() {
        when:
        to ReceptionPage

        then:
        noExceptionThrown()
    }

}
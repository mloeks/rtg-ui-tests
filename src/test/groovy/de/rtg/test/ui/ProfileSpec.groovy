package de.rtg.test.ui


import de.rtg.test.ui.pages.ProfilePage
import spock.lang.PendingFeature

class ProfileSpec extends AbstractRtgSpec {

    def "a user can access their profile"() {
        expect:
        userActor.goToProfile()
    }

    @PendingFeature
    def "a user can change their e-mail address"() {
        given:
        String someNewEmail = 'some.other.address@rtg.com'
        ProfilePage profilePage = userActor.goToProfile()

        expect:
        profilePage.email == userActor.user.email

        when:
        profilePage.email = someNewEmail
        profilePage.save()

        and:
        profilePage = to ProfilePage

        then:
        profilePage.email == someNewEmail
    }

}
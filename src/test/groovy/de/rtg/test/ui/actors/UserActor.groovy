package de.rtg.test.ui.actors

import de.rtg.test.ui.models.User
import de.rtg.test.ui.pages.FoyerPage
import de.rtg.test.ui.pages.ReceptionPage
import geb.Browser

import static de.rtg.test.ui.models.User.createRandom

class UserActor {

    User user
    Browser browser

    public UserActor(Browser browser) {
        this.browser = browser
        user = createRandom()
    }

    public withRegistered() {
        ReceptionPage receptionPage = browser.to ReceptionPage
        receptionPage.register(user)
        assert registrationSuccessful()
        return this
    }

    private boolean registrationSuccessful() {
        FoyerPage foyer = browser.at FoyerPage
        return foyer.loggedInUsername == user.username && foyer.isFirstVisit()
    }

}

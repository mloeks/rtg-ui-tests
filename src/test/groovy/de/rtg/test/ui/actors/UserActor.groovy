package de.rtg.test.ui.actors

import de.rtg.test.ui.models.User
import de.rtg.test.ui.modules.MainMenuModule
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

    public void register() {
        ReceptionPage receptionPage = browser.to ReceptionPage
        receptionPage.register(user)
        assert registrationSuccessful()
    }

    public void logout() {
        FoyerPage foyer = browser.to FoyerPage
        MainMenuModule menu = foyer.openMenu()
        menu.logout.click()
        browser.waitFor { browser.at ReceptionPage }
    }

    public void goToProfile() {
        FoyerPage foyer = browser.to FoyerPage
        MainMenuModule menu = foyer.openMenu()
        menu.userPanel.click()
    }

    private boolean registrationSuccessful() {
        FoyerPage foyer = browser.at FoyerPage
        return foyer.loggedInUsername == user.username && foyer.isFirstVisit()
    }

}

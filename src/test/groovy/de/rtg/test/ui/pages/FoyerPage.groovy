package de.rtg.test.ui.pages

import de.rtg.test.ui.modules.HeaderModule
import de.rtg.test.ui.modules.MainMenuModule
import de.rtg.test.ui.modules.PostModule
import geb.Page

class FoyerPage extends Page {

    static url = "/foyer"

    static at = { $(".qa-foyer-welcome").displayed }

    static content = {
        header { $('.qa-header').module(HeaderModule) }
        username { $('.qa-logged-in-username').text() }
        firstVisitMessage (required: false) { $('.qa-first-visit-notification') }
        posts { $('.qa-post').moduleList(PostModule) }
        mainMenu (required: false) { $('.qa-main-menu').module(MainMenuModule) }
    }

    String getLoggedInUsername() {
        return username
    }

    boolean isFirstVisit() {
        return firstVisitMessage.displayed
    }

    MainMenuModule openMenu() {
        header.openMenu()
        waitFor { mainMenu.displayed }
        return mainMenu as MainMenuModule
    }

}

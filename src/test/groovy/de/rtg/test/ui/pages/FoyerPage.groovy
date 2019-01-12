package de.rtg.test.ui.pages


import de.rtg.test.ui.modules.PostModule
import geb.Page

class FoyerPage extends Page {

    static url = "/foyer"

    static at = { $(".qa-foyer-welcome").displayed }

    static content = {
        username { $('.qa-logged-in-username').text() }
        firstVisitMessage (required: false) { $('.qa-first-visit-notification') }
        posts { $('.qa-post').moduleList(PostModule) }
    }

    String getLoggedInUsername() {
        return username
    }

    boolean isFirstVisit() {
        return firstVisitMessage.displayed
    }
}

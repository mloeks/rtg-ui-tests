package de.rtg.test.ui.pages

import geb.Page

class FoyerPage extends Page {

    static url = "/foyer"

    static at = { $(".qa-foyer-welcome").displayed }

    static content = {
        username { $('.qa-logged-in-username').text() }
        firstVisitMessage (required: false) { $('.qa-first-visit-notification') }
    }

    String getLoggedInUsername() {
        return username
    }

    boolean isFirstVisit() {
        return firstVisitMessage.displayed
    }

}

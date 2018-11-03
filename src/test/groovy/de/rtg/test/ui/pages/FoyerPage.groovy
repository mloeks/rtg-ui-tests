package de.rtg.test.ui.pages

import geb.Page

class FoyerPage extends Page {

    static url = "/foyer"

    static at = { $(".Foyer__welcome").displayed }

    static content = {
        username { $('.Foyer__logged-in-username').text() }
        firstVisitMessage (required: false) { $('.Foyer__first-visit') }
    }

    String getLoggedInUsername() {
        return username
    }

    boolean isFirstVisit() {
        return firstVisitMessage.displayed
    }

}

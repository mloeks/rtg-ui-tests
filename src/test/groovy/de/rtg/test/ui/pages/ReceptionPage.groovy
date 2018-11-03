package de.rtg.test.ui.pages

import geb.Page

class ReceptionPage extends Page {

    static url = "/"

    static at = {
        $(".BigPicture__heading").text() == "Willkommen"
    }

}

package de.rtg.test.ui.pages

import de.rtg.test.ui.models.User
import de.rtg.test.ui.modules.RegisterDialogModule
import geb.Page

class ReceptionPage extends Page {

    static url = "/"

    static at = {
        $(".qa-reception-greeting").text() == "Willkommen"
    }

    static content = {
        registerButton { $('.qa-register-button') }
        registerDialog (required: false) { $('.qa-register-dialog').module(RegisterDialogModule) }
    }

    void register(User user) {
        openRegisterDialog()
        registerDialog.fill(user)
        registerDialog.submit()
        waitFor { browser.at(FoyerPage) }
    }

    private void openRegisterDialog() {
        registerButton.click()
        waitFor { registerDialog.displayed }
    }

}

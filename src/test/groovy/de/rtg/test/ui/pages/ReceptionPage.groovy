package de.rtg.test.ui.pages

import de.rtg.test.ui.models.User
import de.rtg.test.ui.modules.RegisterDialogModule
import geb.Page

class ReceptionPage extends Page {

    static url = "/"

    static at = {
        $(".BigPicture__heading").text() == "Willkommen"
    }

    static content = {
        registerButton { $('.LoginForm__register') }
        registerDialog (required: false) { $('.RegisterDialog').module(RegisterDialogModule) }
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

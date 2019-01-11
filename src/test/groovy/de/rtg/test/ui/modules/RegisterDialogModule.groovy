package de.rtg.test.ui.modules

import de.rtg.test.ui.models.User
import geb.Module

class RegisterDialogModule extends Module {

    static content = {
        registerForm { $('.qa-register-form') }
        submitButton { $('.qa-register-submit') }
    }

    void fill(User user) {
        registerForm.username = user.username
        registerForm.email = user.email
        registerForm.password = user.password
        registerForm.firstName = user.firstName
        registerForm.lastName = user.lastName
    }

    void submit() {
        submitButton.click()
    }

}

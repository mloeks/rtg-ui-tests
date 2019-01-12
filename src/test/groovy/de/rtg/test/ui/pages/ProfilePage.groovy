package de.rtg.test.ui.pages


import geb.Page

class ProfilePage extends Page {

    static url = "/profile"

    static at = { $(".qa-profile-form").displayed }

    static content = {
        username { $('.qa-avatar-username').text() }
        profileForm { $('.qa-profile-form') }
        profileFormSubmit { $('.qa-profile-form-submit') }
        saveSuccess (required: false) { '.qa-profile-save-success' }
    }

    String getEmail() {
        profileForm.email
    }

    String setEmail(String email) {
        // TODO does not recognize email as TextInput, but String instead
        profileForm.email.clear()
        profileForm.email = email
    }

    void save() {
        profileFormSubmit.click()
        waitFor { saveSuccess.displayed }
    }
}

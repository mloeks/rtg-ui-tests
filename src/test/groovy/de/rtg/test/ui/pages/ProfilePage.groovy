package de.rtg.test.ui.pages


import geb.Page

class ProfilePage extends Page {

    static url = "/profile"

    static at = { $(".qa-profile-form").displayed }

    static content = {
        username { $('.qa-avatar-username').text() }
        profileForm { $('.qa-profile-form') }
        profileFormSubmit { $('.qa-profile-form-submit') }
    }
}

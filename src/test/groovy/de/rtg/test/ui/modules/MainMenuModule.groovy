package de.rtg.test.ui.modules

import geb.Module

class MainMenuModule extends Module {

    static content = {
        userPanel { $('.qa-user-panel') }
        logout { $('.qa-logout-button') }
    }

}

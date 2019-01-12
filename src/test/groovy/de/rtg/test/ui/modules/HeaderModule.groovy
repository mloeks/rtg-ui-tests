package de.rtg.test.ui.modules

import geb.Module

class HeaderModule extends Module {

    static content = {
        menuButton { $('.qa-main-menu-button') }
    }

    void openMenu() {
        menuButton.click()
    }

}

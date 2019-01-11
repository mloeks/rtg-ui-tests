package de.rtg.test.ui.config

import geb.Configuration

class ExtendedGebConfiguration extends Configuration {

    ExtendedGebConfiguration(Configuration gebConfig) {
        super(gebConfig.rawConfig, gebConfig.properties, gebConfig.buildAdapter, gebConfig.classLoader)
    }

    String getBaseUrl() {
        readValue(rawConfig, "baseUrl", "https://demo.royale-tippgemeinschaft.de")
    }

    String getApiBaseUrl() {
        readValue(rawConfig, "apiBaseUrl", "https://api.demo.royale-tippgemeinschaft.de")
    }
    
    String getAdminUsername() {
        readValue(rawConfig, "adminUsername", "admin")
    }

    String getAdminPassword() {
        readValue(rawConfig, "adminPassword", "admin")
    }
}

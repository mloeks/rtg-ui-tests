package de.rtg.test.ui

import de.rtg.test.ui.actors.AdminApiActor
import de.rtg.test.ui.actors.UserActor
import de.rtg.test.ui.config.ExtendedGebConfiguration
import de.rtg.test.ui.config.ExtendedGebConfigurationLoader
import geb.Configuration
import geb.spock.GebSpec
import groovy.util.logging.Slf4j
import spock.lang.Shared

@Slf4j
abstract class AbstractRtgSpec extends GebSpec {

    @Shared
    protected UserActor userActor

    @Shared
    protected AdminApiActor adminApiActor

    protected ExtendedGebConfiguration getConfig() {
        return new ExtendedGebConfiguration(createConf())
    }

    @Override
    Configuration createConf() {
        new ExtendedGebConfigurationLoader(gebConfEnv, System.properties,
                new GroovyClassLoader(getClass().classLoader)).getConf(gebConfScript)
    }

    def setupSpec() {
        adminApiActor = new AdminApiActor(config.adminUsername, config.adminPassword, config.apiBaseUrl)

        userActor = new UserActor(browser)
        userActor.register()
    }

    def cleanupSpec() {
        adminApiActor.deleteUser(userActor.user)
    }

}

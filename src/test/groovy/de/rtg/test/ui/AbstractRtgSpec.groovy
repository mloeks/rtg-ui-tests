package de.rtg.test.ui

import de.rtg.test.ui.config.ExtendedGebConfiguration
import de.rtg.test.ui.config.ExtendedGebConfigurationLoader
import geb.Configuration
import geb.spock.GebSpec
import groovy.util.logging.Slf4j

@Slf4j
abstract class AbstractRtgSpec extends GebSpec {

    protected ExtendedGebConfiguration getConfig() {
        return new ExtendedGebConfiguration(createConf())
    }

    @Override
    Configuration createConf() {
        new ExtendedGebConfigurationLoader(gebConfEnv, System.properties,
                new GroovyClassLoader(getClass().classLoader)).getConf(gebConfScript)
    }

}

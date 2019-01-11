import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import java.util.logging.Level

LoggingPreferences loggingPreferences = new LoggingPreferences()
loggingPreferences.enable(LogType.BROWSER, Level.WARNING)

// Test Admin User that must exist on the environment under test
adminUsername = 'rtgtestadmin'
adminPassword = 'V5jeCNxXdf6Xbo'

// DEMO
baseUrl = 'https://demo.royale-tippgemeinschaft.de'
apiBaseUrl = 'https://api.demo.royale-tippgemeinschaft.de'

// LOCAL
//baseUrl = 'http://localhost:3000'
//apiBaseUrl = 'http://localhost:8000'

headless = false
dockerChrome = false

WebDriverManager.chromedriver().setup()

waiting {
    timeout = 10
    retryInterval = 0.5
}


if (dockerChrome) {
    DesiredCapabilities capabilities = new DesiredCapabilities("chrome", "", Platform.ANY)
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences)
    driver = { new RemoteWebDriver("http://127.0.0.1:4444/wd/hub".toURL(), capabilities) }
} else {
    ChromeOptions options = new ChromeOptions()
    options.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences)
    if (headless) {
        options.addArguments("--headless")
    }
    driver = { return new ChromeDriver(options) }
}

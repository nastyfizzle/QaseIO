package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.base.TestListener;
import utils.PropertyReader;

@Listeners(TestListener.class)

public class BaseTest {
    public String user;
    public String password;

    @BeforeMethod
    public void setup() {
        //Implicitly wait
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = PropertyReader.getProperty("qase.url");
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //All clicks using JS
        Configuration.clickViaJs = false;
        user = PropertyReader.getProperty("qase.user");
        password = PropertyReader.getProperty("qase.pass");
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        Selenide.closeWebDriver();
    }
}

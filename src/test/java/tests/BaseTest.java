package tests;

import adapters.ProjectsAdapter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.CaseSteps;
import steps.LoginSteps;
import steps.ProjectSteps;
import tests.base.TestListener;
import utils.PropertyReader;

@Listeners(TestListener.class)

public class BaseTest {
    public String user;
    public String password;

    public LoginSteps loginSteps;
    public ProjectSteps projectSteps;
    public CaseSteps caseSteps;
    public ProjectsAdapter projectsAdapter;

    @BeforeMethod
    public void setup() {
        //Implicitly wait
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = "chrome";
        //Baser URL
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL",
                PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER",
                PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASS",
                PropertyReader.getProperty("qase.pass"));
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //All clicks using JS
        Configuration.clickViaJs = false;
        loginSteps = new LoginSteps();
        projectSteps = new ProjectSteps();
        caseSteps = new CaseSteps();
        projectsAdapter = new ProjectsAdapter();
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        Selenide.closeWebDriver();
    }
}

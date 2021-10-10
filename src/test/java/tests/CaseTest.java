package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest {

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login("nastasv691@gmail.com", "Nastya123!")
                .openProject("TEST_PROJECT");

        //open project by name TEST_PROJECT
        //create case
        //validate case data
    }

}

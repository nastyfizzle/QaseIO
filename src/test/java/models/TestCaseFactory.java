package models;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    static Faker faker;

    public static TestCase getAllFields() {
        faker = new Faker();
        return new TestCase("Check creating a test case using automation tools", "Actual", "You can create a test case using Value Object",
                "Test cases without suite", "Major", "Low", "Functional", "API", "Yes", "", "Positive",
                "Automated", "Create case in the CaseTest class", "");
    }

    public static TestCase getMandatoryFields() {
        return new TestCase("Check creating a test case only with a title");
    }
}

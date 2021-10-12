package models;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    static Faker faker;

    public static TestCase getAllFields() {
        faker = new Faker();
        return new TestCase("Check creating a test case using automation tools", "Actual","Test cases without suite", "Major",
                "Low", "Functional", "API", "Yes", "", "Positive","Automated");
    }

    public static TestCase getMandatoryFields() {
        faker = new Faker();
        return new TestCase(faker.name().title());
    }
}

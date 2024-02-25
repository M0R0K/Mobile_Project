package data;

import com.github.javafaker.Faker;

public class TestData {

    private final Faker faker = new Faker();

    public String searchWord = faker.options().option("Appium", "Java");

}
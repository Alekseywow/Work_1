package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en-UG"));

    public String firstName = faker.name().fullName();
    public String lastName = faker.name().fullName();
    public String userEmail = faker.internet().emailAddress();
    public String genderWrapper = faker.options().option("Male", "Female", "Other");
    public String userPhone = faker.phoneNumber().subscriberNumber(10);
    public String brithData = String.format("%02d", faker.number().numberBetween(1,28));
    public String monthData = faker.options()
            .option("January","February","March","April","May","June","July"
                    ,"August","September","October","November","December");
    public String yearData = String.format("%s", faker.number().numberBetween(1990, 2010));
    public String subjectInput = faker.options().option("Maths", "Accounting", "Arts", "Social Studies");
    public String hobbiesWrapper = faker.options().option("Sports", "Reading", "Music");
    public String imgPicture = faker.options().option("cat.png");
    public String currentAddress = faker.address().fullAddress();
    public String stateCity = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String cityState = getRandomCity(stateCity);

    public String getRandomCity(String stateCity) {
            switch (stateCity) {
                case "NCR":
                    return faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh":
                    return faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana":
                    return faker.options().option("Karnal", "Panipat");
                case "Rajasthan":
                    return faker.options().option("Jaipur", "Jaiselmer");
                default:
                    return null;
            }
    }



}

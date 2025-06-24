package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObject extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formPracticeTest() {

        registrationPage.openPage()
            .setFirstName("Aleksey")
            .setLastName("Danilov")
            .setUserEmail("user@mail.com")
            .setGenderWrapper("Male")
            .setUserNumber("7900900900")
            .setDateOfBrith("26", "September", "1994");

        registrationPage.checkResult("Student Name", "Aleksey Danilov");

    }

}

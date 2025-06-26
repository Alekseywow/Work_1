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
                .setDateOfBrith("26" , "September" , "1994")
                .setSubjectInput("Maths")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("cat.png")
                .setCurrentAddress("Some address 1")
                .setStateCity("NCR")
                .setCityState("Delhi")
                .btnSubmit();


        registrationPage.checkResult("Student Name", "Aleksey  Danilov")
                .checkResult("Student Email", "user@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7900900900")
                .checkResult("Date of Birth", "26 September,1994")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "cat.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void formMinPracticTest(){
        registrationPage.openPage()
                .setFirstName("Aleksey")
                .setLastName("Danilov")
                .setGenderWrapper("Male")
                .setUserNumber("7900900900")
                .btnSubmit();

        registrationPage.checkResult("Student Name", "Aleksey  Danilov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7900900900");
    }

    @Test
    void formNegativePracticTest() {
        registrationPage.openPage()
                .setFirstName("Aleksey")
                .setLastName("Danilov")
                .setGenderWrapper("Male")
                .btnSubmit();

        registrationPage.negativeResult();
    }



}

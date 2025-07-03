package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithFakerTests extends TestBase{


    @Test
    void formPracticeTest() {

        Faker faker = new Faker(new Locale("ru"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();

        //Открытие сайта
        open("/automation-practice-form");
        //Проверка заголовков
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");



        //Ввод данных
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        //Поиск по тексту и клик
        $("#genterWrapper").$(byText("Male")).click();
        //Ввод данных
        $("#userNumber").setValue("7900900900");
        //Раскрытие календаря
        $("#dateOfBirthInput").click();
        //Поиск по тексту и клик
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1994")).click();
        //Опишу чуть позже
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("26")).click();

        //Ввод текста и нажатия энтера
        $("#subjectsInput").setValue("Maths").pressEnter();
        //Поиск по тексту и клик
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //Добавление картинки
        $("#uploadPicture").uploadFromClasspath("cat.png");

        $("#currentAddress").setValue(streetAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        //Проверка заполненных данных
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName),text(lastName));
        $("#closeLargeModal").click();




    }

}

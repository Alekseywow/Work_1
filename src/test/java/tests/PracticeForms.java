package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForms {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void formPracticeTest() {
        //Открытие сайта
        open("/automation-practice-form");
        //Проверка заголовков
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");



        //Ввод данных
        $("#firstName").setValue("Aleksey");
        $("#lastName").setValue("Danilov");
        $("#userEmail").setValue("user@mail.com");
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

        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        //Проверка заполненных данных
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksey"),text("Danilov"));
        $("#closeLargeModal").click();




    }

}

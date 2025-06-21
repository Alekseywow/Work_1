package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }


    @Test
    void fillFormTests() {

        open("/text-box");
        $("#userName").setValue("Aleksey");
        $("#userEmail").setValue("Aleksey@mail.com");
        $("#currentAddress").setValue("Current street 1");
        $("#permanentAddress").setValue("Permament street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Aleksey"));
        $("#output #email").shouldHave(text("Aleksey@mail.com"));
        $("#output #currentAddress").shouldHave(text("Current street 1"));
        $("#output #permanentAddress").shouldHave(text("Permament street 1"));
    }
}

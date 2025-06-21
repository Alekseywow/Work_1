package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpath() {
        $("[data-testid=email]");
        $(by("data-testid", "email"));
        $x("//*[@data-testid='email']");

        $("[id=email]");
        $(by("data-testid", "email"));
        $(byId("email"));
        $("#email");
        $x("//*[@id='email']");

        $("[name=email]");
        $(by("name", "email"));
        $(byName("email"));
        $x("//*[@name='email']");

        $("[class=inputtext], [class=login_form]");
        $(".login_form");
        $("inputtext.login_form");
        $("input.inputtext.login_form");
        $x("//input[@class='inputtext'][@class='login_form']");


        $("inputtext .login_form");
        $("inputtext").$("login_form");
        $("div.inputtext").$("input.login_form");
        $("div.inputtext input.login_form");

        $(byText(""));
        $(withText(""));
        $x("//*[text()='Hello']");
        $x("//*[contains(text()='Hello')]");

    }

}

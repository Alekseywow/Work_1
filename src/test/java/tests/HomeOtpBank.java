package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HomeOtpBank {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openOtpBankTest() {
        open("https://www.otpbank.ru/");
        $(withText("Продолжая просмотр сайта")).shouldBe(visible);
        $(byTagAndText("strong", "Закрыть")).click();
        $(withText("Продолжая просмотр сайта")).shouldBe(hidden);
        sleep(5000);
    }

    @Test
    void pageObject() {
        new LoginBankOtp().loginUsernameAndPassword("user", "1234");
        new HomeBankOtp().title.shouldHave(text("My balance"));
        new HomeBankOtp().showAccountBalance();


        new LoginBankOtp2().loginUsernameAndPassword("user", "1234")
                .showAccountBalance();
    }
}

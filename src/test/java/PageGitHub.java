import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class PageGitHub {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }



    @Test
    void successSearchAiPlatform() {
        open("https://github.com");
        $(".HeaderMenu-nav").$(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a","Enterprises")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

        sleep(5000);
    }

}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsSelenideTests {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "Fix pull request close test";


    @Test
        void stepLambdaTest() {



        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по ссылке реозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Кликаем таб pull-request", () -> {
            $("#pull-requests-tab").click();
        } );

        step("Проверяем наличие issue c текстом " + ISSUE, () -> {
            $("#issue_91_link").shouldHave(text(ISSUE)).shouldBe(exist);
        });
}

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithText(ISSUE);
    }

}

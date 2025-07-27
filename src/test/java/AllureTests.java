import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureTests extends TestBase{

    WebSteps steps = new WebSteps();


    @Test
    void selenideTest() {
        open(baseUrl);
        $(".header-search-button").click();
        $("#query-builder-test").setValue("Alekseywow/Work_1").pressEnter();
        $("a[href='/Alekseywow/Work_1']").click();
        $("#issues-tab").click();
        $("a[href='/Alekseywow/Work_1/issues/3']").shouldHave(text("Welcome to issue"));
    }

    @Test
    void lambdaTest() {
        step("Открываем главную страницу ", () -> {
            open(baseUrl);
        });

        step("Кликаем на поиск и вводим имя репозитория " + REPOSITORY,  () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue("Alekseywow/Work_1").pressEnter();
        });

        step("Кликаем на ссылку репозитория " + REPOSITORY, () -> {
            $("a[href='/Alekseywow/Work_1']").click();
        });

        step("Нажимаем на вкладку ISSUES", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие заголовка под название " + ISSUES, () -> {
            $("a[href='/Alekseywow/Work_1/issues/3']").shouldHave(text("Welcome to issue"));
        });

    }

    @Test
    void stepTest() {
        steps.openMainPage(baseUrl);
        steps.searchRepository(REPOSITORY);
        steps.clickRepository();
        steps.clickIssuesTab();
        steps.checkIssues(ISSUES);

    }

}

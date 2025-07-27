package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозиторий под названием {repo}")
    public void searchRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue("Alekseywow/Work_1").pressEnter();
    }

    @Step("Кликаем на ссылку найденного репозитория")
    public void clickRepository() {
        $("a[href='/Alekseywow/Work_1']").click();
    }

    @Step("Кликаем на вкладку ISSUES")
    public void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие заголовка под название {issues}")
    public void checkIssues(String issues) {
        $("a[href='/Alekseywow/Work_1/issues/3']").shouldHave(text("Welcome to issue"));
    }

}

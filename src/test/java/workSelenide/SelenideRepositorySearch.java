package workSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

     //ARRANGE - Подготовка
     //ACT - Действие
     //ASSERT - Проверка


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldByFindTestGitHub() {

        //Открыть главную страницу
        open("https://github.com/");

        //выбрать поле поиска и ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        // кликнуть на первый репозиторий из списка найденных
        $$("[data-testid='results-list']").first().$("a").click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }

}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    public static final String REPOSITORY = "Alekseywow/Work_1";
    public static final String ISSUES = "Welcome to issues";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1980x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        // Этот вызов подключает автоматическую интеграцию Selenide с системой отчётности Allure,
        // позволяя получать более подробные и удобные отчёты о выполнении автоматизированных тестов.
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}

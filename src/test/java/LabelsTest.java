import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @BeforeAll
    static void setUp() {

        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Aleksey")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Isssue для авторизованного пользователя")
        void testStaticLabel() {

    }

    @Test
    public void testDinamicLabel() {

    }

}

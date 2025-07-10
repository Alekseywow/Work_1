package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import qa.guru.data.Language;
import qa.guru.data.Person;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWebTest {

    @BeforeAll
    static void setUps() {
        Configuration.pageLoadStrategy = "eager";
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    void selenideSiteDisplayCorrectText(Language language){
        open("https://selenide.org");
        $$("#languages a").find(text(language.name())).click();
        $("h3").shouldHave(text(language.description));
    }

    static Stream<Arguments> selenideSiteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Language.RU,
                        List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"),
                        new Person("Aleksey", 30)
                ),
                Arguments.of(
                        Language.EN,
                        List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"),
                        new Person("Aleksey", 30)
                )

        );
    }

    @MethodSource
    @ParameterizedTest
    void selenideSiteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons, Person person) {
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(language.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(texts(expectedButtons));
    }



}

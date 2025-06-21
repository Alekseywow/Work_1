package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_command_examples() { // работа с командой браузера
        open("https://google.com"); // Прямой урл
        open("/customer/orders");     // -Dselenide.baseUrl=http://123.23.23.1 // относительный урл
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password")); // можно открывать через попап

        Selenide.back(); // Команда шаг назад
        Selenide.refresh(); // Команда обновить страницу

        Selenide.clearBrowserCookies(); // чистка кэша все
        Selenide.clearBrowserLocalStorage(); // чистка локал сторедж
        executeJavaScript("sessionStorage.clear();"); // no Selenide command for this yet // очистка сессии

        Selenide.confirm(); // OK in alert dialogs // команда ок в диалоговом окне
        Selenide.dismiss(); // Cancel in alert dialogs // команда закрыть в диалоговом окне

        Selenide.closeWindow(); // close active tab // закрывает только одно окно
        Selenide.closeWebDriver(); // close browser completely // закрывает все браузеры

        Selenide.switchTo().frame("new");  // переходим внутри фрейма и ищем конкретное имя
        Selenide.switchTo().defaultContent(); // return from frame back to the main DOM // возвращение к главному дереву страницы

        Selenide.switchTo().window("The Internet"); // перемещаться к конкретному окну

        var cookie = new Cookie("foo", "bar"); // определяем куки
        WebDriverRunner.getWebDriver().manage().addCookie(cookie); // установление куков

    }

    void selectors_examples() {
        $("div").click(); // поиск по элементу
        element("div").click(); // поиск по элементу Kotlin

        $("div", 2).click(); // the third div // поиск div третьего

        $x("//h1/div").click(); // поиск элемента по классу
        $(byXpath("//h1/div")).click(); // поиск элемента по классу

        $(byText("full text")).click(); // поиск по тексту
        $(withText("ull tex")).click(); // поиск по частичному тексту

        $(byTagAndText("div", "full text")); // поиск по элементу и тексту
        $(withTagAndText("div", "ull text")); // поиск по элементу и частичному тексту

        $("").parent(); // родительский элемент
        $("").sibling(1); // брат/сестра вниз по дереву
        $("").preceding(1); // брат/сестра вверх по дереву
        $("").closest("div"); // поиск предка по элементу
        $("").ancestor("div"); // the same as closest // поиск предка по элементу
        $("div:last-child"); // поиск последнего ребенка

        $("div").$("h1").find(byText("abc")).click(); // находим  элемент / внутри него находим первый элемент / внутри него находим пр тексту / и кликаем
        // very optional
        $(byAttribute("abc", "x")).click(); // поиск по атрибуту
        $("[abc=x]").click(); // поиск по атрибуту

        $(byId("mytext")).click();// поиск по id
        $("#mytext").click(); // поиск по id

        $(byClassName("red")).click(); //поиск по class
        $(".red").click(); //поиск по class
    }

    void actions_examples() {
        $("").click(); // один клик
        $("").doubleClick(); // двойной клик
        $("").contextClick(); // правый клие

        $("").hover(); // наведение

        $("").setValue("text"); // записываем текст
        $("").append("text"); // добавляем текст
        $("").clear(); // очищение поля, может иногда работать неправильно
        $("").setValue(""); // очищение поля

        $("div").sendKeys("c"); // hotkey c on element // Симуляция нажатия клавиши
        actions().sendKeys("c").perform(); //hotkey c on whole application // абстрактно симулировать нажатие клавиши
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F // комбинация клавиш
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); // посылает на корневой элекмент

        $("").pressEnter(); // Нажатие энтера
        $("").pressEscape(); // Нажатие эскейта
        $("").pressTab(); // Нажатие таба


        // complex actions with keybord and mouse, example // с клавиатурой и мышкой комплексно
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option"); // выбрать в выпадающем списке нужный элемент
        $("").selectRadio("radio_options"); //  выбрать в радиобаттон нужный элекмент
    }

    void assertions_examples() {
        $("").shouldBe(visible); //видимый элемент
        $("").shouldNotBe(visible); // не видемый элемент
        $("").shouldHave(text("abc")); // присутствует данный текст в элементе
        $("").shouldNotHave(text("abc")); // отсуствует данный текст в элементе
        $("").should(appear); // присутствует кнопка
        $("").shouldNot(appear); // отсутствует кнопка


        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30)); // увеличение или уменьшение проверки
        // тут так же проверяем видимый элекмент

    }

    void conditions_examples() {
        $("").shouldBe(visible); // видимость чего то
        $("").shouldBe(hidden); // отпуствие видимости чего то

        $("").shouldHave(text("abc"));  // видимость текста (возможно что длинный текст и часть может присутствовать)
        $("").shouldHave(exactText("abc")); // проверяет только конкретный текст
        $("").shouldHave(textCaseSensitive("abc")); // проверка с большой буквы
        $("").shouldHave(exactTextCaseSensitive("abc")); // проверка с маленькой юуквы
        $("").should(matchText("[0-9]abc$")); // проверка формата email или дата (для сложных проверок)

        $("").shouldHave(cssClass("red")); // содержит ли элемент данный класс
        $("").shouldHave(cssValue("font-size", "12")); // провер размер текста

        $("").shouldHave(value("25")); // поиск по строке
        $("").shouldHave(exactValue("25")); // поиск по подстроке
        $("").shouldBe(empty); // проверка поля пустого

        $("").shouldHave(attribute("disabled")); // существует ли атрибут
        $("").shouldHave(attribute("name", "example")); //проверка значения атриюута
        $("").shouldHave(attributeMatching("name", "[0-9]abc$")); // проверка конкретного атрибута

        $("").shouldBe(checked); // for checkboxes // проверка чекбокса

        // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist); // проверка наличия элемента в доме, но не его видимость

        // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled); // проверка на отсутствие чего то
        $("").shouldBe(enabled);  // проверка на присутствие чего то
    }

    void collections_examples() {

        $$("div"); // does nothing! // можно собрать все элементы

        $$x("//div"); // by XPath //

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1)); // фильтрование по тексту
        $$("div").excludeWith(text("123")).shouldHave(size(1)); // противоположность верхнему, оставляет только те, которые не соответствуют тексту

        $$("div").first().click(); //поиск первый элемент
        elements("div").first().click();
        // $("div").click();
        $$("div").last().click(); // последний элемент
        $$("div").get(1).click(); // the second! (start with 0) // поиск по номеру элемента
        $("div", 1).click(); // same as previous // первый элемент
        $$("div").findBy(text("123")).click(); //  finds first // комбинаци фильтра и первого элемента

        // assertions
        $$("").shouldHave(size(0)); // проверка размера
        $$("").shouldBe(CollectionCondition.empty); // the same / проверка пустой команды

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); // проверяет кол-во текста
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma")); // проверка и на кол-во и написание

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa")); // игнорирует порядок текста
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa")); //тот же чтоо и выше

        $$("").shouldHave(itemWithText("Gamma")); // only one text // проверка что есть 1 элемент с текстом

        $$("").shouldHave(sizeGreaterThan(0)); // больше нуля элементов
        $$("").shouldHave(sizeGreaterThanOrEqual(1)); // больше или равно одному элементу
        $$("").shouldHave(sizeLessThan(3)); // меньше трех элементо
        $$("").shouldHave(sizeLessThanOrEqual(2)); // меньше или равно двух элементов

    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // only for <a href=".."> links // работает для обычных файлов и скачивает их
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid // строка которая работает всегда для скачивания

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt"); // выбирает файл
        // don't forget to submit!
        $("uploadButton").click(); // после клика файл загружается
    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')"); //
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7); // получения от JS какого то значения

    }

}

package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFileTests {

    @Test
    void downloadFileTest() throws Exception {
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        File downloaded =
                $(".react-blob-header-edit-and-raw-actions [href*='main/README.md']")
                        .download(); // Находит ссылку на "Raw" или прямое скачивание файла README.md.

        try (InputStream is = new FileInputStream(downloaded)) { // Создает поток чтения из скачанного файла.
            byte[] data = is.readAllBytes(); // Читает все байты из файла в массив data.
            String dataAsString = new String(data, StandardCharsets.UTF_8); // Преобразует байты в строку, предполагая кодировку UTF-8.
            Assertions.assertTrue(dataAsString.contains("Contributions to JUnit are both welcomed and appreciated"));
            // Проверяет, содержит ли содержимое файла указанную строку.
        }

        System.out.println();


    }

    @Test
    void uploadFileTest() {
        open("");
        $("").uploadFromClasspath(); // Загружает файл из classpath (ресурсы проекта) в выбранный элемент формы для загрузки файла.
        $("").shouldHave(text("");  // Проверяет, что этот элемент содержит определенный текст (text("")).
    }



}

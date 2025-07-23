package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.As;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import guru.qa.model.Glossary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    //Эта строка создает приватную переменную cl, которая содержит ссылку на загрузчик классов текущего класса (FileParsingTest).
    //Ее можно использовать для получения ресурсов из classpath в дальнейшем в коде.

    private static final Gson gson = new Gson();
    // Эта строка создает один постоянный экземпляр Gson для работы с JSON в классе.

    @Test
    void pdfFileParsingTest() throws Exception {
        open("");
        File downloaded = $("").download(); //Находит элемент и скачивает PDF-файл.
        PDF pdf = new PDF(downloaded); // Создает объект для парсинга этого файла.
        Assertions.assertEquals(""); //Выполняет проверку содержимого файла на соответствие ожидаемому значению.
    }

    @Test
    void xlsFileParsingTest() throws Exception {
        open();
        File download = $("").download(); // Находит элемент и скачивает XLS file
        XLS xls = new XLS(download); // Создает объект для парсинга этого файла
        String actualValue = xls.excel.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();// Это способ извлечь конкретное значение из файла Excel по его расположению.
        Assertions.assertTrue(actualValue.contains("")); // Проверяет, содержит ли полученное значение ожидаемую подстроку
    }


    @Test
    void csvFileParsingTest() throws Exception {
        try(InputStream is = cl.getResourceAsStream(""); // Использует cl — переменную типа ClassLoader, которая была объявлена ранее. Вызов getResourceAsStream("") ищет ресурс внутри classpath по указанному пути и возвращает его как поток (InputStream).
            CSVReader csvReader = new CSVReader(new InputStreamReader(is))) { // Это позволяет читать CSV-файл построчно и разбивать его на поля.
            List<String[]> data = csvReader.readAll(); // весь файл загружается в память в виде списка массивов.
            Assertions.assertEquals(
                    new String[] {""},
                    data.get(0) // Выполняет проверки содержимого первых строк файла на соответствие ожидаемым значениям.
            );
            Assertions.assertEquals(
                    new String[] {""},
                    data.get(1) // Выполняет проверки содержимого первых строк файла на соответствие ожидаемым значениям.
            );

        }
    }

    @Test
    void zipFileParsingTest() throws Exception {
        try(ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("") // Оборачивает этот поток в ZipInputStream, который позволяет читать ZIP-архив по частям.
        )) {
            ZipEntry entry;  // Создается переменная для хранения текущей записи внутри ZIP-файла.

            while ((entry = zis.getNextEntry()) !=null) { // Перебирает все файлы и папки внутри архива.
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void jsonFileParsingTest() throws Exception {
        try( Reader reader = new InputStreamReader(
                cl.getResourceAsStream("") // Получает поток для файла внутри ресурсов проекта по указанному пути. В текущем коде путь пустой — нужно указать реальный путь к JSON-файлу.
        )) {
            JsonObject actual = gson.fromJson(reader, JsonObject.class); // это класс из Gson, представляющий JSON-объект (набор пар "ключ-значение").

            Assertions.assertEquals("", actual.get("").getAsString());
            Assertions.assertEquals("", actual.get("").getAsInt());

            JsonObject inner = actual.get("").getAsJsonObject();

            Assertions.assertEquals("", inner.get("").getAsString());
            Assertions.assertEquals("", inner.get("").getAsString());
            Assertions.assertEquals("", inner.get("").getAsString());

        }

    }

    @Test
    void jsonFileParsingProvedTest() throws Exception {
        try( Reader reader = new InputStreamReader(
                cl.getResourceAsStream("")
        )) {
            Glossary actual = gson.fromJson(reader, Glossary.class); // Читает JSON из reader, преобразует его в объект типа Glossary.

            Assertions.assertEquals("", actual.getTitle());
            Assertions.assertEquals("", actual.getID());
            Assertions.assertEquals("", actual.getGlossary().getSortAs());
            Assertions.assertEquals("", actual.getGlossary().getAcronym());
            Assertions.assertEquals("", actual.getGlossary().getGlossTerm());

        }

    }


}

package model;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();// Получение ClassLoader для загрузки ресурсов из проекта или JAR.

    @Test
    void checkPdfFileParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test.zip"); // Загружаете ресурс "test.zip" как поток.
            ZipInputStream zis = new ZipInputStream(is)) { // Создается поток для чтения ZIP-архива из исходного InputStream.
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) !=null) { // Проходите по всем записям внутри ZIP.
                if (entry.getName().contains(".pdf")) { // Проверяете, содержит ли имя файла ".pdf".
                    PDF pdf = new PDF(zis); // Создаете объект PDF, передавая текущий поток (который указывает на содержимое файла внутри ZIP).
                    Assertions.assertEquals(pdf.numberOfPages, 2); //Проверяете, что у PDF 2 страницы.
                }
            }

        }

    }

    @Test
    void checkXlsxFileParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("test.zip");
            ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) !=null) { // Перебираем все файлы внутри ZIP-архива
                if (entry.getName().contains(".xlsx")) { // Проверяем, содержит ли имя файла расширение ".xlsx"
                    XLS xls = new XLS(zis); // // Создаем объект XLS для парсинга Excel файла из текущего потока
                    String value = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue(); // Получаем значение первой ячейки первого листа Excel файла
                    Assertions.assertTrue(value.contains("Расписание")); // Проверяем, что значение содержит слово "Расписание"
                }
            }
        }

    }

    @Test
    void checkCsvFileParsingTest() throws Exception {
        try(InputStream is = cl.getResourceAsStream("test.zip");
        ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) !=null) {
                if (entry.getName().contains(".csv")) { // Проверяем, содержит ли имя файла расширение ".csv"
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis)); // Создаем CSVReader для чтения CSV файла из текущего потока
                    List<String[]> strings = csvReader.readAll(); // Читаем все строки CSV файла в список строк
                    Assertions.assertEquals(1, strings.size()); // Проверяем, что в файле содержится ровно одна строка
                }
            }
        }
    }

}

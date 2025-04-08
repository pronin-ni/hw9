import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesZipParsingTest {
    private final ClassLoader classLoader = FilesZipParsingTest.class.getClassLoader();
    boolean isFileFound = false;

    @DisplayName("Проверка парсинга pdf файла в zip архиве")
    @Test
    void pdfFileInZipParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(classLoader.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().equals("Диплом_Иван_И.1.pdf")) {
                    isFileFound = true;
                    PDF pdf = new PDF(zip);
                    assertTrue(pdf.text.contains("Тестовое мероприятие"));
                }
            }
            assertTrue(isFileFound,"Файл не найден");
        }
    }

    @DisplayName("Проверка парсинга excel файла в zip архиве")
    @Test
    void excelFileInZipParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(classLoader.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().equals("indicatorsReport (3).xlsx")) {
                    isFileFound = true;
                    XLS xlsx = new XLS(zip);
                    assertTrue(xlsx.excel.getSheetAt(0).getRow(2).getCell(1).getStringCellValue().equals("Перечень показателей деятельности ЦОПП"));
                    assertTrue(xlsx.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue().equals("Созданы цифровая платформа и сайт ЦОПП в сети Интернет"));
                }
            }
            assertTrue(isFileFound,"Файл не найден");
        }
    }

    @DisplayName("Проверка парсинга csv файла в zip архиве")
    @Test
    void csvFileInZipParsingTest() throws Exception {
        try (ZipInputStream zip = new ZipInputStream(classLoader.getResourceAsStream("archive.zip"))) {
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().equals("errors_Spark ru companies adapter_2025-01-17.csv")) {
                    isFileFound = true;
                    CSVParser parser = new CSVParserBuilder()
                            .withSeparator(';')
                            .build();
                    CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(zip, StandardCharsets.UTF_8))
                            .withCSVParser(parser)
                            .build();
                        assertThat(csvReader).contains(
                                new String[] {"770600206610277394386825", "Internal Error", "Request length limit exceeded: 4096"},
                                new String[] {"77120881501027739729270197", "Decode Error", "Failed to decode result (LoadCompanyLinks): CompanyLinkResponseBody parse error"}
                        );
                    }
                }
            assertTrue(isFileFound,"Файл не найден");
        }
        }
    }
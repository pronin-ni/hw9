import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParsingTest {

    private static final String jsonFile = "src/test/resources/extraction_settings.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("Тест парсинга json файла")
    void jsonParsingTest() throws Exception {

        File file = new File(jsonFile);
        ExtractionSettings extractionSettings = objectMapper.readValue(file, ExtractionSettings.class);

        assertNotNull(extractionSettings);
        assertEquals(300, extractionSettings.getOcrDPI());
        assertEquals(3, extractionSettings.getAttempts());
        assertEquals(List.of("rus", "eng"), extractionSettings.getLanguages());
        assertTrue(extractionSettings.isAllowEmpty());
        assertEquals("NO_OCR", extractionSettings.getOcrStrategy());
        assertTrue(extractionSettings.isAllowPartials());
        assertTrue(extractionSettings.isPdfDetectAngles());
        assertEquals("10 minutes",extractionSettings.getExtractionTimeout());
        assertFalse(extractionSettings.isAllowTotalException());
        assertEquals( 4294967296L,extractionSettings.getPdfMaxMainMemoryBytes());
        assertTrue(extractionSettings.isAllowTemporalException());
        assertTrue(extractionSettings.isPdfExtractInlineImages());
        assertTrue(extractionSettings.isAllowStoreOriginalFiles());
        assertEquals(50000000L, extractionSettings.getMemoryUsageSourceSizeBytes());
        assertEquals(10737418240L, extractionSettings.getOriginalFilesBufferSizeBytes());
        assertEquals(1, extractionSettings.getProcessingResourceConsumption());
    }
}

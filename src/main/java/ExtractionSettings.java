import java.util.List;

public class ExtractionSettings {
    private int ocrDPI;
    private int attempts;
    private List<String> languages;
    private boolean allowEmpty;
    private String ocrStrategy;
    private boolean allowPartials;
    private boolean pdfDetectAngles;
    private String extractionTimeout;
    private boolean allowTotalException;
    private long pdfMaxMainMemoryBytes;
    private boolean allowTemporalException;
    private boolean pdfExtractInlineImages;
    private boolean allowStoreOriginalFiles;
    private long memoryUsageSourceSizeBytes;
    private long originalFilesBufferSizeBytes;
    private int processingResourceConsumption;

    public int getOcrDPI() {
        return ocrDPI;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public boolean isAllowEmpty() {
        return allowEmpty;
    }

    public String getOcrStrategy() {
        return ocrStrategy;
    }

    public boolean isAllowPartials() {
        return allowPartials;
    }

    public boolean isPdfDetectAngles() {
        return pdfDetectAngles;
    }

    public String getExtractionTimeout() {
        return extractionTimeout;
    }

    public boolean isAllowTotalException() {
        return allowTotalException;
    }

    public long getPdfMaxMainMemoryBytes() {
        return pdfMaxMainMemoryBytes;
    }

    public boolean isAllowTemporalException() {
        return allowTemporalException;
    }

    public boolean isPdfExtractInlineImages() {
        return pdfExtractInlineImages;
    }

    public boolean isAllowStoreOriginalFiles() {
        return allowStoreOriginalFiles;
    }

    public long getMemoryUsageSourceSizeBytes() {
        return memoryUsageSourceSizeBytes;
    }

    public long getOriginalFilesBufferSizeBytes() {
        return originalFilesBufferSizeBytes;
    }

    public int getProcessingResourceConsumption() {
        return processingResourceConsumption;
    }
}

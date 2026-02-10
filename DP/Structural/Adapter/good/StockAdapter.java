public class StockAdapter implements StockProvider {
    private final LegacyStockEngine legacyEngine;

    public StockAdapter(LegacyStockEngine engine) {
        this.legacyEngine = engine;
    }

    @Override
    public double getPriceInJson() {
        // 1. Get the incompatible data (XML)
        String xml = legacyEngine.getRawXmlData();
        
        // 2. Translate/Map the data to the expected format
        System.out.println("Adapter: Converting XML data to double...");
        String priceStr = xml.substring(xml.indexOf("<price>") + 7, xml.indexOf("</price>"));
        
        return Double.parseDouble(priceStr);
    }
}
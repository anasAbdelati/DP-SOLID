/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Tight Coupling: The UI is now forced to 'import' and understand LegacyXML library.
 * 2. Violation of SRP: The UI is now responsible for both displaying data AND parsing XML.
 * 3. Fragile: If the Legacy library updates its XML format, the UI code breaks.
 */
class StockDisplayBad {
    public void showPrice(LegacyStockEngine legacy) {
        // The UI is doing dirty translation work
        String xml = legacy.getRawXmlData();
        String price = xml.substring(xml.indexOf("<price>")+7, xml.indexOf("</price>"));
        
        System.out.println("Displaying Price: " + price);
    }
}
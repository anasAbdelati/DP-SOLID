public class ModernApp {
    public static void main(String[] args) {
        // We have the legacy service
        LegacyStockEngine legacyService = new LegacyStockEngine();

        // We wrap it in the Adapter
        StockProvider provider = new StockAdapter(legacyService);

        // The App only knows about the StockProvider interface
        // No XML logic is visible here!
        double currentPrice = provider.getPriceInJson();
        
        System.out.println("Modern App: The current price is $" + currentPrice);
    }
}
public class RealTradeExecutor implements TradeExecutor {
    public RealTradeExecutor() {
        // Heavy lifting only happens when this class is instantiated
        openExpensiveSocket();
    }

    private void openExpensiveSocket() {
        System.out.println("REAL_SERVICE: Establishing 10Gbps Dedicated Link...");
    }

    @Override
    public void executeTrade(String stock, int qty) {
        System.out.println("REAL_SERVICE: Placing trade for " + qty + " shares of " + stock);
    }
}
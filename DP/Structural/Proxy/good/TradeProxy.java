public class TradeProxy implements TradeExecutor {
    private RealTradeExecutor realExecutor;
    private final String userRole;

    public TradeProxy(String userRole) {
        this.userRole = userRole;
        System.out.println("PROXY: Proxy initialized. No network cost incurred yet.");
    }

    @Override
    public void executeTrade(String stock, int qty) {
        // 1. Protection Proxy logic (Security)
        if (!"TRADER_LEVEL_1".equals(userRole)) {
            System.out.println("PROXY: Access Denied. User lacks trading clearance.");
            return;
        }

        // 2. Virtual Proxy logic (Lazy Loading)
        // We only pay the $500/hr connection cost when a trade is ACTUALLY placed.
        if (realExecutor == null) {
            System.out.println("PROXY: Initializing expensive connection now...");
            realExecutor = new RealTradeExecutor();
        }

        // 3. Delegation
        realExecutor.executeTrade(stock, qty);
    }
}
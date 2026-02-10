public class TradingApp {
    public static void main(String[] args) {
        // Scenario 1: Unauthorized user (No cost incurred)
        System.out.println("--- Scenario: Intern tries to trade ---");
        TradeExecutor internAccess = new TradeProxy("INTERN");
        internAccess.executeTrade("TSLA", 100);

        System.out.println("\n--- Scenario: Senior Trader trades ---");
        // Connection is only opened here, at the exact moment of execution
        TradeExecutor seniorAccess = new TradeProxy("TRADER_LEVEL_1");
        seniorAccess.executeTrade("AAPL", 500);
        
        // Subsequent trades use the same lazy-loaded connection
        seniorAccess.executeTrade("GOOGL", 10);
    }
}
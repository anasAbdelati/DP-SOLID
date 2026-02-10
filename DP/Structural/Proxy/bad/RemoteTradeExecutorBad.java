/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Financial Disaster: The constructor opens a $500/hr connection immediately. 
 * Simply 'newing' this class in a test suite would bankrupt the company.
 * 2. Zero Security: The 'execute()' method has no guard. Any thread can call it.
 * 3. Coupling: The client is directly tied to the heavy, networked implementation.
 */
class RemoteTradeExecutorBad {
    public RemoteTradeExecutorBad() {
        System.out.println("CRITICAL: Opening expensive 10Gbps Socket to NYSE...");
        System.out.println("CRITICAL: Connection established. Charging $500/hr.");
    }

    public void executeTrade(String stock, int qty) {
        System.out.println("Executing Trade: Buying " + qty + " of " + stock);
    }
}
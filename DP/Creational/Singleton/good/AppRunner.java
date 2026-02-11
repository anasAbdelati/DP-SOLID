public class AppRunner {
    public static void main(String[] args) {
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();

        db1.query("SELECT * FROM users");
        
        if (db1 == db2) {
            System.out.println("SUCCESS: Both references point to the same memory address.");
        }
    }
}
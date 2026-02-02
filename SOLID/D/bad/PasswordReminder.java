package bad;

/**
 * VIOLATION: Tight Coupling.
 * This high-level class depends directly on a low-level concrete class (MySQLConnection).
 */
public class PasswordReminder {
    private final MySQLConnection dbConnection;

    public PasswordReminder() {
        // ERROR: Hard-coded dependency. 
        // We cannot use any other database without changing this code.
        this.dbConnection = new MySQLConnection();
    }
    
    public void remind() {
        dbConnection.connect();
    }
}
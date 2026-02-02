package good;

public class PasswordReminder {
    private DBConnection dbConnection;

    /**
     * DEPENDENCY INJECTION:
     * We don't create the connection here. We "inject" it.
     * This class is now decoupled from the specific database type.
     */
    public PasswordReminder(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void remind() {
        dbConnection.connect();
    }
}
public class DatabaseConnector {
    // volatile ensures the instance is visible across all threads correctly
    private static volatile DatabaseConnector instance;
    private String connectionString;

    private DatabaseConnector() {
        this.connectionString = "jdbc:postgresql://localhost:5432/prod";
        System.out.println("SINGLETON: Establishing the UNIQUE physical connection...");
    }

    // Senior-Level: Double-Checked Locking for thread safety and performance
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnector.class) {
                if (instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing: " + sql);
    }
}
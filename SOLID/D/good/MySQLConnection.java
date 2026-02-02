package good;

public class MySQLConnection implements DBConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL DBMS...");
    }
}
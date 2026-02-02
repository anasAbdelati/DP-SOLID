package good;

// We can now add new databases easily!
public class InterSystemsIRISConnection implements DBConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to InterSystems IRIS globals...");
    }
}
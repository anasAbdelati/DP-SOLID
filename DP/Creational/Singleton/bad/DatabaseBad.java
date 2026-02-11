/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Resource Exhaustion: Every 'new' call creates a physical connection.
 * 2. Inconsistency: State (isEncrypted) is not shared between instances.
 */
class DatabaseBad {
    private boolean isEncrypted = false;

    public DatabaseBad() {
        System.out.println("CRITICAL: Opening a NEW physical DB Connection...");
    }

    public void setEncrypted(boolean val) { this.isEncrypted = val; }
}
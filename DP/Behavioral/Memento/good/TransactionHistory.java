import java.util.Stack;

public class TransactionHistory {
    private final Stack<TransactionMemento> checkpoints = new Stack<>();

    public void save(BankTransaction tx) {
        checkpoints.push(tx.createCheckpoint());
    }

    public void undo(BankTransaction tx) {
        if (!checkpoints.isEmpty()) {
            tx.rollback(checkpoints.pop());
        } else {
            System.out.println("History: No checkpoints found.");
        }
    }
}
public interface Visitor {
    void visit(SavingsAccount savings);
    void visit(LoanAccount loan);
}
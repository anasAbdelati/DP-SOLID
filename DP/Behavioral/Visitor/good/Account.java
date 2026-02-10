public interface Account {
    // This is the "hook" that allows the Visitor into the object
    void accept(Visitor v);
}
public class HomeOwner {
    public static void main(String[] args) {
        // One object, one method call. Senior level simplicity.
        SmartHomeFacade theater = new SmartHomeFacade();
        
        theater.watchMovie("Interstellar");
        
        System.out.println("\n--- 3 Hours Later ---\n");
        
        theater.endMovie();
    }
}
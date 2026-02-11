/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Mixing Families: Nothing stops us from creating an IPhone with a SamsungWatch.
 * 2. Hardcoded logic: If we add 'Google' as a brand, we have to change the App logic.
 * 3. High Coupling: The client has to know the exact class names of every single product.
 */
class SamsungPhoneBad {
    public void display() { System.out.println("Samsung Phone Displayed."); }
}

class AppleWatchBad {
    public void display() { System.out.println("Apple Watch Displayed."); }
}

class PhoneStoreBad {
    public void createKit(String brand) {
        if (brand.equals("Apple")) {
            // Manual pairing is error-prone
            System.out.println("Creating Apple Kit...");
        } else if (brand.equals("Samsung")) {
            // ERROR RISK: A dev could accidentally put 'new IPhoneBad()' here
            SamsungPhoneBad phone = new SamsungPhoneBad();
            AppleWatchBad watch = new AppleWatchBad(); // Mixing brands!
            phone.display();
            watch.display();
        }
    }
}
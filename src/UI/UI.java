package UI;
import Controller.Controller;
import Model.*;
import java.util.Scanner;
public class UI {
    Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();
    public void run() {
        while(true){
            show();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addProperty();
                case 2 -> updateProperty();
                case 3 -> deleteProperty();
                case 4 -> viewProperty();
                case 5 -> viewAllProperties();
                case 6 -> {
                    System.out.println("Thank you for using the Real Estate Agency App!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private void show() {
        System.out.println("---- Real Estate Agency ----");
        System.out.println("1. Add Property");
        System.out.println("2. Update Property");
        System.out.println("3. Delete Property");
        System.out.println("4. View Property by ID");
        System.out.println("5. View All Properties");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addProperty(){
        //TODO
    }
    private void updateProperty(){
        //TODO
    }
    private void deleteProperty(){
        //TODO
    }
    private void viewProperty(){
        //TODO
    }
    private void viewAllProperties(){
        //TODO
    }
}

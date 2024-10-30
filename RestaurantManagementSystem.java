import java.util.Scanner;

public class RestaurantManagementSystem {
    private Menu menu;
    private Inventory inventory;
    private Scanner scanner;

    public RestaurantManagementSystem() {
        menu = new Menu();
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Manage Menu");
            System.out.println("2. Process Orders");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageMenu();
                    break;
                case 2:
                    processOrders();
                    break;
                case 3:
                    manageInventory();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageMenu() {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dish price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter dish category: ");
        String category = scanner.nextLine();
        menu.addDish(name, price, category);
        System.out.println("Dish added to the menu.");
    }

    private void processOrders() {
        Order order = new Order();
        while (true) {
            System.out.println("Menu:");
            for (Dish dish : menu.getDishes()) {
                System.out.println(dish);
            }
            System.out.print("Enter dish name to order (or 'done' to finish): ");
            String dishName = scanner.nextLine();
            if (dishName.equals("done")) {
                break;
            }
            for (Dish dish : menu.getDishes()) {
                if (dish.getName().equals(dishName)) {
                    order.addDish(dish);
                    System.out.println("Added " + dishName + " to the order.");
                    break;
                }
            }
        }
        System.out.print("Enter tax rate (as a decimal): ");
        double tax = scanner.nextDouble();
        System.out.print("Enter tip amount: ");
        double tip = scanner.nextDouble();
        System.out.println("Total bill: $" + order.calculateTotalBill(tax, tip));
    }

    private void manageInventory() {
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        inventory.addIngredient(name, quantity);
        System.out.println("Ingredient added to inventory.");
    }

    public static void main(String[] args) {
        RestaurantManagementSystem rms = new RestaurantManagementSystem();
        rms.start();
    }
}

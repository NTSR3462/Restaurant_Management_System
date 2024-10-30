import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> orderedDishes;
    private double totalBill;

    public Order() {
        orderedDishes = new ArrayList<>();
        totalBill = 0.0;
    }

    public void addDish(Dish dish) {
        orderedDishes.add(dish);
        totalBill += dish.getPrice();
    }

    public void modifyQuantity(Dish dish, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addDish(dish);
        }
    }

    public double calculateTotalBill(double tax, double tip) {
        return totalBill + (totalBill * tax) + tip;
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu() {
        dishes = new ArrayList<>();
    }

    public void addDish(String name, double price, String category) {
        dishes.add(new Dish(name, price, category));
    }

    public void updateDishPrice(String name, double newPrice) {
        for (Dish dish : dishes) {
            if (dish.getName().equals(name)) {
                dish.setPrice(newPrice);
                break;
            }
        }
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}

class Dish {
    private String name;
    private double price;
    private String category;

    public Dish(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (" + category + ")";
    }
}

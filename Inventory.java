import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> ingredients;

    public Inventory() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(String name, int quantity) {
        ingredients.put(name, ingredients.getOrDefault(name, 0) + quantity);
    }

    public void useIngredient(String name, int quantity) {
        if (ingredients.containsKey(name)) {
            int currentQuantity = ingredients.get(name);
            if (currentQuantity >= quantity) {
                ingredients.put(name, currentQuantity - quantity);
            }
        }
    }

    public int getQuantity(String name) {
        return ingredients.getOrDefault(name, 0);
    }

    public boolean isLowStock(String name, int threshold) {
        return getQuantity(name) < threshold;
    }
}

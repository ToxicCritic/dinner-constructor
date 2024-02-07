package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;

    public DinnerConstructor() {
        dishesByType = new HashMap<>();
        //
    }

    public void addDish(String dishType, String dishName) {
        ArrayList<String> dishes;
        if (dishesByType.containsKey(dishType)) {
            dishes = dishesByType.get(dishType);
        } else {
            dishes = new ArrayList<>();
        }
        dishes.add(dishName);
        dishesByType.put(dishType, dishes);
        System.out.println(dishName + " добавлено в категорию " + dishType);
    }
}

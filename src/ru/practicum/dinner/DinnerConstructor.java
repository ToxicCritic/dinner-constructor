package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

    public void createCombination (ArrayList<String> dishTypes) {
        Random random = new Random();
        ArrayList<String> combo = new ArrayList<>();

        for (String element : dishesByType.keySet()) {
            for (String inputType : dishTypes) {
                if (inputType.equals(element)) {
                    int dishesInCategory = dishesByType.get(inputType).size();
                    int randNum = random.nextInt(dishesInCategory);
                    combo.add(dishesByType.get(inputType).get(randNum));
                }
            }
        }
        System.out.println(combo);
    }
    public boolean checkType(String Type) {
        for (String element : dishesByType.keySet()) {
            if (element.equals(Type)) {
                return true;
            }
        }
        return false;
    }
}

package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public static void main(String[] args) {
        DishOrderDeterminer dod = new DishOrderDeterminer();
        dod.determineDishOrder(11, 4);
    }
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> result = new ArrayList<>();
        if (numberOfDishes == 0) return result;

        ArrayList<Integer> dishLeftArr = new ArrayList<Integer>();
        for (int i = 0; i < numberOfDishes; i++) {
            dishLeftArr.add(i + 1);
        }


        int pointerInd = everyDishNumberToEat - 1;
        while (dishLeftArr.size() > 0) {
            result.add(dishLeftArr.get(pointerInd));
            dishLeftArr.remove(pointerInd);
            pointerInd += everyDishNumberToEat - 1;

            if (pointerInd >= dishLeftArr.size()) {
                if (dishLeftArr.size() == 1) {
                    pointerInd = 0;
                } else {
                    pointerInd = pointerInd - dishLeftArr.size();
                }
            }
        }

        return result;
    }
}

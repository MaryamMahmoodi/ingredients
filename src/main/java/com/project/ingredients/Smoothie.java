package com.project.ingredients;

import java.util.*;

public class Smoothie
{
    public static String ingredients(String order) {

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        Map<String, List<String>> menu = new HashMap<>();
        menu.put("Classic", Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
        menu.put("Freezie", Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));
        menu.put("Greenie", Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));
        menu.put("Just Desserts", Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry"));

        String[] orderParts = order.split(",");
        String smoothieToMake = orderParts[0];

        // Check if the requested smoothie is in the menu
        if (!menu.containsKey(smoothieToMake)) {
            throw new IllegalArgumentException("Smoothie not found in the menu");
        }

        List<String> smoothieIngredients = new ArrayList<>(menu.get(smoothieToMake));


        // Remove excluded ingredients from the smoothie
        for (int i = 1; i < orderParts.length; i++) {
            String ingredient = orderParts[i].startsWith("-") ? orderParts[i].substring(1) : orderParts[i];
            if (!smoothieIngredients.contains(ingredient)) {
                // If the excluded ingredient is not in the smoothie, ignore it
                continue;
            }
            else if (orderParts[i].startsWith("-")) {
                smoothieIngredients.remove(ingredient);
            }
            else
            {
                throw new IllegalArgumentException("Invalid input: additional ingredients not supported");
            }
        }

        // Sort and join the ingredients with commas
        Collections.sort(smoothieIngredients);
        return String.join(",", smoothieIngredients);
    }//end of method

}

package com.pluralsight;

import java.util.ArrayList;

public class StoreApp {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    // this method loads product objects into inventory
    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(1, "Apple", 1.50));
        inventory.add(new Product(2, "Banana", 1.40));
        inventory.add(new Product(3, "Cheese", 11.99));
        inventory.add(new Product(4, "Coffee", 4.99));
        inventory.add(new Product(5, "Pizza", 2.99));
        inventory.add(new Product(6, "Rice", 9.99));
        inventory.add(new Product(7, "Pepper", 8.99));


        return inventory;
    }
}
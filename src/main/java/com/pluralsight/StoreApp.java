package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreApp {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");

        for (Product product : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    product.getId(), product.getName(), product.getPrice());
        }
    }

    // this method loads product objects into inventory
    public static ArrayList<Product> getInventory() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/inventory.csv");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<Product> inventory = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            //Split the line using (|)
            String[] values = line.split("\\|");

            //Assigning line parts to variables
            int id = Integer.parseInt(values[0]);
            String name = values[1];
            double price = Double.parseDouble(values[2]);
            inventory.add(new Product(id, name, price));
        }
        return inventory;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
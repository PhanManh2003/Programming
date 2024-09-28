/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Product;
import java.util.ArrayList;

/**
 *
 * @author manhpthe172481
 */
public class ManageProduct {

    private static ArrayList<Product> list = new ArrayList<>();

    public ManageProduct() {
    }

    public static ArrayList<Product> getList() {
        return list;
    }

    static void update(String id, String name, String provider, double price) {
        for (Product product : list) {
            if (product.getId().equalsIgnoreCase(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setProvider(provider);

            }
        }
    }

    static void delete(String id) {
        ArrayList<Product> productsToRemove = new ArrayList<>();
        for (Product product : list) {
            if (product.getId().equalsIgnoreCase(id)) {
                productsToRemove.add(product);
            }
        }
        list.removeAll(productsToRemove);
    }

}

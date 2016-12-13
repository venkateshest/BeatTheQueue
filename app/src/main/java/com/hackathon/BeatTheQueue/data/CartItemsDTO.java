package com.hackathon.BeatTheQueue.data;

/**
 * Created by venkatesh.kolla.
 */
public class CartItemsDTO {

    public String name;
    public int quantity;
    public double price;
    public double perKGPrice;

    public CartItemsDTO(String name, int quantity, double price, double perKGPrice) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.perKGPrice = perKGPrice;
    }
}

package com.hackathon.BeatTheQueue.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by venkatesh.kolla.
 */
public class CartItemsDTO implements Parcelable {

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

    protected CartItemsDTO(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
        perKGPrice = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(quantity);
        dest.writeDouble(price);
        dest.writeDouble(perKGPrice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CartItemsDTO> CREATOR = new Creator<CartItemsDTO>() {
        @Override
        public CartItemsDTO createFromParcel(Parcel in) {
            return new CartItemsDTO(in);
        }

        @Override
        public CartItemsDTO[] newArray(int size) {
            return new CartItemsDTO[size];
        }
    };
}

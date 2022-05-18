package com.mike.protobuf;

import com.mike.models.Car;
import com.mike.models.Dealer;

public class MapDemo {
    public static void main(String[] args) {
        Car accord = Car.newBuilder().setMake("honda")
                .setModel("accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder().setMake("honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Dealer dealer = Dealer.newBuilder().putModel(2020, accord)
                .putModel(2005, civic).build();

        System.out.println(
//                dealer.getModelOrThrow(2006)
                dealer.getModelOrThrow(2005).getBodyStyle()
        );
    }
}

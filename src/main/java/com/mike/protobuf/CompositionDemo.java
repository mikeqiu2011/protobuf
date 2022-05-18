package com.mike.protobuf;

import com.mike.models.Address;
import com.mike.models.Car;
import com.mike.models.Person;

public class CompositionDemo {
    public static void main(String[] args) {
        Address address = Address.newBuilder().setPostbox(123)
                .setStreet("main street")
                .setCity("atlanta")
                .build();

        Car accord = Car.newBuilder().setMake("honda")
                .setModel("accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder().setMake("honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Person sam = Person.newBuilder().setName("sam")
                .setAge(10)
                .setAddress(address)
                .addCar(accord)
                .addCar(civic)
                .build();

        System.out.println(sam);
    }
}

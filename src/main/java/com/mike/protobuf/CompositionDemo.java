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

        Car car = Car.newBuilder().setMake("honda")
                .setModel("accord")
                .setYear(2020)
                .build();

        Person sam = Person.newBuilder().setName("sam")
                .setAge(10)
                .setAddress(address)
                .setCar(car)
                .build();

        System.out.println(sam);
    }
}

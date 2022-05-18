package com.mike.protobuf;

import com.google.protobuf.Int32Value;
import com.mike.models.Address;
import com.mike.models.Car;
import com.mike.models.Person;

import java.util.ArrayList;
import java.util.List;

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

        List<Car> cars = new ArrayList<>();
        cars.add(accord);
        cars.add(civic);


        Person sam = Person.newBuilder().setName("sam")
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .setAddress(address)
                .addAllCar(cars)
                .build();

        System.out.println(sam);
    }
}

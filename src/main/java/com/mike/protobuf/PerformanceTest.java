package com.mike.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.mike.json.JPerson;
import com.mike.models.Person;

public class PerformanceTest {
    public static void main(String[] args) {
        // json
        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        ObjectMapper mapper = new ObjectMapper();


        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // protobug
        Person sam = Person.newBuilder()
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .setName("sam").build();

        System.out.println(
                sam.hasAge()
        );

        Runnable proto = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                Person sam1 = Person.parseFrom(bytes);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {

            runPerformanceTest(proto, "protobuf");
            runPerformanceTest(json, "json");
        }


    }


    private static void runPerformanceTest(Runnable runnable, String method) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        long end = System.currentTimeMillis();

        System.out.println(
                method + " : " + (end - start) + " ms"
        );
    }
}

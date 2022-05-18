package com.mike.protobuf;

import com.mike.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {
//        Television television = Television.newBuilder().setBrand("Sony")
//                .setYear(2019).build();
//
//        Path pathV1 = Paths.get("tv-v1");
//        Files.write(pathV1, television.toByteArray());
//        simulate client is also using v1 to talk to us
        Path pathV1 = Paths.get("tv-v1");
        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(
                Television.parseFrom(bytes).getModel()
        );
    }
}

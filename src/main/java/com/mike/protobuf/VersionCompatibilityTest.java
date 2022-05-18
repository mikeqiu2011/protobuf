package com.mike.protobuf;

import com.mike.models.Television;
import com.mike.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {
        Television television = Television.newBuilder().setBrand("Sony")
                .setModel(2020)
                .setType(Type.OLED)
                .build();

        Path pathV2 = Paths.get("tv-v2");
        Files.write(pathV2, television.toByteArray());

//        Path pathV1 = Paths.get("tv-v1");
//        byte[] bytes = Files.readAllBytes(pathV1);
//        System.out.println(
//                Television.parseFrom(bytes).getModel()
//        );
    }
}

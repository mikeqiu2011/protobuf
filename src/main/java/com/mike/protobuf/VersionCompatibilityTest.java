package com.mike.protobuf;

import com.mike.models.Television;
import com.mike.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {
        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");
        Path pathV3 = Paths.get("tv-v3");

        Television television = Television.newBuilder().setBrand("Sony")
                .setType(Type.OLED)
                .build();

        Files.write(pathV3, television.toByteArray());

//        byte[] bytes = Files.readAllBytes(pathV2);
//        System.out.println(
//                Television.parseFrom(bytes)
//        );
    }
}

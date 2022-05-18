package com.mike.protobuf;

import com.mike.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {
        Television television = Television.newBuilder().setBrand("Sony")
                .setYear(2019).build();

        Path path = Paths.get("tv-v1");
        Files.write(path, television.toByteArray());
    }
}

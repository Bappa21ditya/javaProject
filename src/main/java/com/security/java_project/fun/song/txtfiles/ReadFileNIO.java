package com.security.java_project.fun.song.txtfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFileNIO {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Path.of("/Users/bappadityaroy/Desktop"));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

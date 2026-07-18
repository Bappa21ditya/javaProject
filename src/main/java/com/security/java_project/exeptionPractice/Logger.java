package com.security.java_project.exeptionPractice;
import java.io.FileWriter;
import java.io.IOException;
public class Logger {
    public static void log(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}

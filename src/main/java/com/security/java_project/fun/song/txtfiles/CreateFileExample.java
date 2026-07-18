package com.security.java_project.fun.song.txtfiles;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CreateFileExample {
    public static void main(String[] args) {
        // 🖥️ Path to your Desktop (change username if needed)
        String desktopPath = System.getProperty("user.home") + "/Desktop/myFile.txt";

        File file = new File(desktopPath);

        try {
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getAbsolutePath());
            } else {
                System.out.println("⚠️ File already exists at: " + file.getAbsolutePath());
            }

            try (FileWriter writer = new FileWriter(file)) { // overwrites by default
                writer.write("Hello from Java! 💻\n");
                writer.write("This text is written to your file.\n");
                writer.write("You can change or add more lines as needed.\n");
                System.out.println("✅ Text written successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

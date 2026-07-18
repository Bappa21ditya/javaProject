package com.security.java_project.fun.song.txtfiles;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class writetotextfile {
    public static void main(String[] args) {
        String desktopPath = System.getProperty("user.home") + "/Desktop/myFile.txt";

        File file = new File(desktopPath);


        // ✍️ Write text into the file
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("1! 💻\n");
            writer.write("2\n");
            writer.write("3.\n");
            System.out.println("✅ Text written successfully!");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}

package com.security.java_project.fun.song.txtfiles;

import org.springframework.boot.autoconfigure.ssl.SslProperties;

import java.io.*;

public class ReadFileExample {

    public static void main(String args[])
    {
        String desktopPath=System.getProperty("user.home") + "/Desktop/myFile.txt";
        File file=new File(desktopPath);

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;
            System.out.println("📄 File content:");
            while ((line= bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            System.out.println("✅ Done reading file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

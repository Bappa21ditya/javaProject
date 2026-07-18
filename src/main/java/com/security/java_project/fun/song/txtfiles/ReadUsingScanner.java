package com.security.java_project.fun.song.txtfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadUsingScanner {

    public  static void main(String args[])
    {
       String desktopPath=System.getProperty("user.home")+ "/Desktop/myFile.txt";
        File file= new File(desktopPath);

        try {
            Scanner sc= new Scanner(file);
            while (sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

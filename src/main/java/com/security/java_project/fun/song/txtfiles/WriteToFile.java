package com.security.java_project.fun.song.txtfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String args[])
    {
        String data ="Hello, this is a text file example!\\nWelcome to Java file handling.";
      try {
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
          bufferedWriter.write(data);
          System.out.println("✅ Data written to output.txt");
      }
      catch (IOException e)
      {
   e.printStackTrace();
      }
    }
}

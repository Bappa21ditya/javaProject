package com.security.java_project.fun.song;

public class PrintSongTypingEffect {
    public static void main(String[] args) throws InterruptedException {

        String[] lyrics = {
                "সারা রাতটা হুলুক বুলুক করে কাটালি ❤️",
                "ভোর রাতে চাবি ঢোকায় তালা খুলে দিলি! 💫",
                "আমার বছর বছর জমা ধন-টা ও তুই আজকে লুটে লিলি রে, 🌙",

        };

        int charDelay = 100;   // delay per character (ms)
        int lineDelay = 500;   // delay after each line (ms)

        for (String line : lyrics) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                Thread.sleep(charDelay);  // small pause between chars
            }

            System.out.println();  // move to next line
            Thread.sleep(lineDelay);  // short pause between lines
        }

    }
}






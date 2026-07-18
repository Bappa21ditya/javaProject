package com.security.java_project.fun.song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

public class AudioLyricsSync {
    public static void main(String[] args) {
        try {
            // 1️⃣ Load and play the audio (must be .wav)
            File file = new File("/Users/bappadityaroy/Downloads/java_project/src/main/java/com/security/java_project/fun/song/bulbuli.wav");
            AudioInputStream audioStream = getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // 2️⃣ Start playing
            clip.start();
            System.out.println("🎶 Playing song...বাগিচায় বুলবুলি তুই \n");
            Thread.sleep(2500);

            // 3️⃣ Lyrics with timings (seconds)
            String[] lyrics = {
                    "বাগিচায় বুলবুলি তুই, ফুল শাখাতে ❤️",
                    "দিসনে আজই দোল! 💫",
                    "আজও তার, 🌙",
                    "ফুল কলিদের ঘুম টুটেনি ,❤️ ",
                    " তন্দ্রাতে বিলোল , 💫",

                    "বাগিচায় বুলবুলি তুই, ফুল শাখাতে ❤️",
                    "দিসনে আজই দোল! 💫",
                    "আজও তার, 🌙",
                    "ফুল কলিদের ঘুম টুটেনি ,❤️ ",
                    " তন্দ্রাতে বিলোল , 💫"
            };

            int charDelay = 120;   // delay per character (ms)
            int lineDelay = 1200;   // delay after each line (ms)

            for (String line : lyrics) {
                for (char c : line.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(charDelay);  // small pause between chars
                }

                System.out.println();  // move to next line
                Thread.sleep(lineDelay);  // short pause between lines
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

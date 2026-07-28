package com.security.java_project.system_design.patterns.CompositePattern;

public class CompositionPatternApplicationMain {
    public static void main(String[] args) {

        File file1 =
                new File("A.txt",100);

        File file2 =
                new File("B.txt",200);

        Folder documents =
                new Folder("Documents");

        documents.add(file1);
        documents.add(file2);

        Folder desktop =
                new Folder("Desktop");

        desktop.add(documents);

        desktop.showDetails();

        System.out.println(
                desktop.getSize());
    }
}

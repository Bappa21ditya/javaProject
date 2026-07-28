package com.security.java_project.system_design.patterns.CompositePattern;

public class File implements FileSystemItem{

    private String name;

    private int size;

    public File(String name,
                int size){

        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails(){

        System.out.println(name);
    }

    @Override
    public int getSize(){

        return size;
    }
}



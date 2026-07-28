package com.security.java_project.system_design.patterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem{

    private String name;

    List<FileSystemItem> children=new ArrayList<>();



    public Folder(String name){

        this.name = name;
     //   this.size = size;
    }

    public void add(FileSystemItem item)
    {
        children.add(item);
    }
    public void remove(FileSystemItem item)
    {
        children.remove(item);
    }

    @Override
    public void showDetails(){

        System.out.println(name);

        for(FileSystemItem child: children)
        {
            child.showDetails();
        }
    }

    @Override
    public int getSize(){
        int total=0;

        for(FileSystemItem child: children)
        {
           total+=child.getSize();
        }
        return total;
    }
}

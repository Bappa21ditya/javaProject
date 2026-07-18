package com.security.java_project.steamquestions;

public class Employee {
    int salary;
    String name;
    int age;

   public Employee(int salary,String  name,int age)
    {
        this.salary=salary;
        this.name=name;
        this.age=age;
    }
   public int  getAge()
    {
        return age;
    }
   public int getSalary()
    {
        return salary;
    }
    public  String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

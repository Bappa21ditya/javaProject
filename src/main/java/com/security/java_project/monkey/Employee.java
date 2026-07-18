package com.security.java_project.monkey;

public class Employee {

    int age;
    int salary;
    String name;

    public Employee(int age, int salary, String name)
    {
        this.age=age;
        this.salary=salary;
        this.name=name;
    }

   public int getAge()
    {
        return age;
    }
   public String getName()
    {
        return name;
    }
    public int getSalary()
    {
        return salary;
    }
    @Override
    public String toString() {
        return name+ age + " (" + salary + ")" ;
    }
}




package com.security.java_project.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class student{
    int age;
    String name;

    student(int age,String name)
    {
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return age + " (Name: " + name + ")";
    }
}

public class Streams {


    public static void main(String args[]) {
        ArrayList<Integer> a1 = new ArrayList();

        for (int i = 0; i <= 10; i++) {
            a1.add(i);
        }
//        a1.stream().filter(num -> num % 2 == 0)
//                .forEach(System.out::println);


        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(30);
        a2.add(20);

        a2.forEach(System.out::println);
        a2.stream().sorted().forEach(System.out::println);
        Map<String,Integer> map=new HashMap<>();
        map.put("bappa",1);
        map.put("cappa",2);
        map.forEach((str,i)-> System.out.println(str+""+i));


        student s1=new student(1,"riju");
        student s2=new student(2,"aubho");
        student s3=new student(3,"supro");
        List<student> studentList= Arrays.asList(s1,s2,s3);

   //     studentList.stream().sorted((student1,student2)->student1.age-student2.age).forEach(student ->System.out.println(student.age+""+student.name) );
studentList.stream().sorted((student1,student2)->student1.name.compareTo(student2.name)).forEach(s10 -> System.out.println(s10.age+""+s10.name));
   // studentList.stream().map()

        List<Integer> a11=Arrays.asList(1,2,3,4,5,6,7,8);
        // filter(use predicate return true, false
        a11.stream().filter(n-> {return n%2==0;}).forEach(n-> System.out.println(n));
        a11.stream().filter(n->n%2==1).forEach(System.out::println);
//convert into anotherform
        List<String> s11=Arrays.asList("abc","def","zghi","jkl");
        s11.stream().map(str->str.toUpperCase()).forEach(System.out::println);
// sorting
        s11.stream().sorted().forEach(System.out::println);
        //reducr
        System.out.println(a11.stream().reduce(0,(a,b)->a+b));

        Map<String,student> m= Stream.of(s1,s2).collect(Collectors.toMap(student -> student.name,student -> student));
        m.forEach((key,value)-> System.out.println(key+" "+value));

        student s10 = new student(20,"Bappa");
        student s20 = new student(22,"Cappa");
        student s30 = new student(20,"Dappa");
        student s40 = new student(22,"Eappa");
        student s50 = new student(23,"Fappa");

        // Creating a List of Students
        List<student> students = List.of(s10, s20, s30, s40, s50);

        Map<Integer,List<student>> m11=students.stream().collect(Collectors.groupingBy(student ->student.age));
        m11.forEach((age,student)->{
            System.out.println(age+" "+student);
        });
        m11.forEach((age, studentList1) ->
                System.out.println("Age " + age + " -> " + studentList1));

       int[] Aarray={1,2,3,4,5};
       List<Integer> l1= Arrays.asList(1,2,3,4,5);
    //   l1.stream().




    }
}

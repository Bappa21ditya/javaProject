package com.security.java_project.monkey;

import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Monkey {

    public static void main(String agrs[]) {

//        List<String> names= Arrays.asList("doneky","deer","beer","lion","tiger");
//
//        //creating streams
//        Stream<String> stream= names.stream();
//
//        stream.forEach(System.out::println);
//
//        filter and collect
//List<String> s1=Arrays.asList("doneky","deer","beer","lion","tiger");
//  List<String>r1= s1.stream().filter(n ->n.startsWith("d")).collect(Collectors.toList());
//  System.out.println(r1);
//
//        Map and Sort
//        List<String> s1=Arrays.asList("doneky","deer","beer","lion","tiger");
//        List<String>r1= s1.stream().map(n->n.toUpperCase()).sorted().collect(Collectors.toList());
//        System.out.println(r1);
//
//         reduce
//        List<Integer> n1=Arrays.asList(10,20,30,40);
//        int sum=n1.stream().reduce(0,(a,b)->a+b);
//
//        System.out.println("sum:" +sum);
//
//        Employee e1 = new Employee(25, 80000, "beer");
//        Employee e2 = new Employee(27, 200000, "tiger");
//        List<Employee> employeeList = Arrays.asList(e1, e2);
//
//        Employee maxSalEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
//
//        System.out.println(maxSalEmp.getName());
//
//        List<Employee>maxSalEmp1= employeeList.stream().sorted(Comparator.comparingInt(e->e.getSalary())).collect(Collectors.toList());
//
//        List<Employee>maxSalEmp1= employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
//      System.out.println(maxSalEmp1);
//
//List<Employee> maxEmpSalAge=     employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparingInt(Employee::getAge)).collect(Collectors.toList());
//System.out.println(maxEmpSalAge);
//
//        List<String> names = Arrays.asList("Java", "Python", "C++", "Go");
//
//        List<String> sortedByLength = names.stream()
//                .sorted(Comparator.comparingInt(String::length))
//                .collect(Collectors.toList());
//
//        System.out.println(sortedByLength);
//// [Go, Java, Python, C++]
//
//        // 14. Join strings with delimiter
//
//       String result= names.stream().collect(Collectors.joining(","));
//       System.out.println(result);
//
//       // to UpperCase
//
//      List<String>r3=  names.stream().map(e->e.toUpperCase()).collect(Collectors.toList());
//      System.out.println(r3);
//
//      // Partition numbers into even and odd
//
//
//      //11. Find common elements between two lists
//
//
//        //10. Sort a list of strings by length
//
//        List<String> sorted= names.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
//    System.out.println(sorted);
//
//      // Find all numbers starting with 1
//
//        List<Integer> list = Arrays.asList(10, 25, 15, 35, 105);
//        List<Integer> startsWith1 = list.stream()
//                .map(String::valueOf)
//                .filter(s->s.startsWith("1"))
//                .map(Integer::valueOf)
//                .collect(Collectors.toList());
//
//        System.out.println(startsWith1);
//
//
    }
}


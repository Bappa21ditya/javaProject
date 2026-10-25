package com.security.java_project.streams;

import java.util.*;
import java.util.stream.Collectors;

public class streamapi {

    public static void main(String args[])
    {

       // 1. Basic filtering
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 5);
        List<Integer> r1 = l1.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers in l1: " + r1);

        // 2. FlatMap with list of lists
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> evenNumbers = lists.stream()
                .flatMap(n -> n.stream().filter(m -> m % 2 == 0))
                .collect(Collectors.toList());
        System.out.println("Even numbers flattened: " + evenNumbers);

        // 3. Max element
        int maxVal = l1.stream().max(Integer::compareTo).get();
        System.out.println("Max value: " + maxVal);

        // 4. Summing integers
        int sum = l1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // 5. Corrected Employee list call
        List<Employee> employees = Employee.getEmployeeList();
        System.out.println("Total employees loaded: " + employees.size());

        // 6.Group by Department

        Map<String, List<Employee>> groupedEmployees=employees.stream().collect(Collectors.groupingBy(e->e.getDepartment()));

        groupedEmployees.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            System.out.println("Employees: " + empList);
            System.out.println("--------------------");
        });

        // 7.Department Highest Earner

        Map<String, Employee> highestEarner = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                emp -> emp.orElse(null)
                        )
                ));

      // Print the results
        highestEarner.forEach((dept, emp) -> {
            System.out.println("Department: " + dept + " -> Highest Earner: " + emp.getName() + " ($" + emp.getSalary() + ")");
        });

        Double secondHighestSalary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second highest salary amount: " + secondHighestSalary);

        Optional<Employee> secondHighestEarner = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();

    // Print the result safely
        if (secondHighestEarner.isPresent()) {
            Employee emp = secondHighestEarner.get();
            System.out.println("Second Highest Earner: " + emp.getName() + " ($" + emp.getSalary() + ")");
        } else {
            System.out.println("Not enough employees to find a second highest.");
        }
     }


}

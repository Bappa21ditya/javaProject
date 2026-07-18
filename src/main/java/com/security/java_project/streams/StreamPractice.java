package com.security.java_project.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String args[])
    {
        List<Integer> l1= Arrays.asList(1,2,3,4,5,5);
        //1. find the even in odd list

        l1.stream().filter(n->n%2==0).forEach(System.out::println);

       //2. Convert List to Uppercase
        List<String> names = Arrays.asList("java", "stream");
        names.stream().map(n->n.toUpperCase()).forEach(System.out::println);

       //3. Find First Element
        Optional<String> first = names.stream().findFirst();
        first.ifPresent(System.out::println);

        //4.Remove Duplicates
        List<Integer> list = Arrays.asList(1,2,2,3,3,4);
        List<Integer> result = list.stream()
                .distinct()
                .collect(Collectors.toList());

        // 5.count elemts'
        long r1= l1.stream().count();

       // 6.Sort List
        List<Integer> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());

      //  7.Descending:
        List<Integer> reverseSorted=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

     // 8.Find min or max
     int r2=list.stream().max(Integer::compare).get();
     int r3=list.stream().max(Integer::compare).get();

       // 9.Sum of Numbers
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        long r4= list.stream().reduce((a,b)-> a+b).get();
        System.out.println("sum of the all number is "+r4);


       // 10.give me all the dupliacte present inside the list
        HashSet<Integer> hashSet=new HashSet<>();
        l1.stream().filter(n->!hashSet.add(n)).forEach(System.out::println);

        //11.Grouping (VERY IMPORTANT 🔥)
        Map<Integer, List<Integer>> grouped=l1.stream().collect(Collectors.groupingBy(n->n%2));
        System.out.println(grouped);

        //12.Count Occurrence of Each Element
        Map<Integer, Long> countMap=l1.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
       //13.  Find Duplicate Elements
        Set<Integer> duplicates = list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .collect(Collectors.toSet());
        // 14. Join Strings
        String result1 = names.stream()
                .collect(Collectors.joining(","));

        System.out.println(result1); // java,stream

        //15. Partitioning (VERY IMPORTANT)
        Map<Boolean, List<Integer>> partition = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        //Difference from grouping:
   // Partition → only true/false
    //    Grouping → multiple keys

        List<List<Integer>> list3 = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4)
        );

        List<Integer> result3 = list3.stream().flatMap(Collection::stream).collect(Collectors.toList());

        //16.Find Second Highest Number (VERY IMPORTANT 🔥)
       int r5 = l1.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(r5);

       //17. Check If All Match Condition
        boolean allEven = list.stream()
                .allMatch(n -> n % 2 == 0);
 //18. Any Match
        boolean hasEven = list.stream()
                .anyMatch(n -> n % 2 == 0);
  // 19. None Match
        boolean noneNegative = list.stream()
                .noneMatch(n -> n < 0);
   //20.Convert List to Map
         Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> "Number " + n
                ));





    }
}

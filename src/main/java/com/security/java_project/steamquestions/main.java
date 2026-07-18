package com.security.java_project.steamquestions;

import com.security.java_project.monkey.Employee;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static void main(String args[])
    {
        List<Integer> l1= Arrays.asList(1,2,3,4,5,6,7,8,9,10,15,17,18,18,2);
        List<String> a1= Arrays.asList("apple","amla","pumpkin");

       //1. Find even numbers from a list
         List<Integer>r1=l1.stream().filter(n->n%2==0).collect(Collectors.toList());
         System.out.println(r1);
        //2.Find odd numbers from a list
          List<Integer> r2 =l1.stream().filter(n->n%2!=0).toList();
          System.out.println(r2);

       // 3. Find numbers greater than 10
          List<Integer> r3=l1.stream().filter(n->n>10).toList();
          System.out.println(r3);

        //4. Find strings starting with 'A'
          List<String>r4= a1.stream().filter(n->n.startsWith("a")).toList();
          System.out.println(r4);

       //5. Find duplicate elements in a list

          // Using Collections.frequency() (Simple & Readable)
             Set<Integer> r5 = l1.stream().filter(n-> Collections.frequency(l1,n)>1).collect(Collectors.toSet());
             System.out.println(r5);

          //  Using Set (Efficient, No Frequency Counting)

            HashSet<Integer> set1=new HashSet<>();
            Set<Integer> duplicates=l1.stream().filter(n->!set1.add(n)).collect(Collectors.toSet());
            System.out.println(duplicates);

         // Keep Only Duplicates (Preserve Order)

            HashSet<Integer> set2=new HashSet<>();
            List<Integer> duplicates2=l1.stream().filter(n->!set2.add(n)).toList();
            System.out.println(duplicates2);

    // need to learn
        //Using groupingBy() Collector
                List<String> names = Arrays.asList("Alex", "Bob", "John", "Alex", "Bob", "Sam");
                Set<String> duplicates3 = names.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                        .entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());
                   System.out.println(duplicates3); // [Alex, Bob]

       // Method	                  Approach                    	         Performance	Best For
        //Collections.frequency()	  Count each item	O(n²)	                 Small lists
        //Using Set.add()	          Hash-based detection	O(n)	             Large lists
        //groupingBy()	              Map-based counting	O(n)	             When you need counts
        //Stream filter with Set	  Detects duplicates in order	O(n)	     Order-sensitive tasks


        //6. Find unique elements from a list

        List<Integer> distinct = l1.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);


        List<Integer>r6=l1.stream().filter(n->Collections.frequency(l1,n)==1).toList();
        System.out.println(r6);

// need to learn
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates6 = new HashSet<>();

        list.forEach(i -> {
            if (!seen.add(i)) duplicates6.add(i);
        });

        List<Integer> unique = list.stream()
                .filter(i -> !duplicates6.contains(i))
                .collect(Collectors.toList());

        System.out.println(unique); // [3, 4, 5]




        //7. Find first element in a list
          Integer r7=l1.stream().findFirst().get();
          System.out.println(r7);

        //8. Find last element in a list

        int last = list.stream()
                .reduce((first, second) -> second)
                .orElseThrow();

        System.out.println(last);


        //9. Find maximum element in a list
        //Integer r9=l1.stream().max((a,b)->a.compareTo(b)).get();
        Integer r9=l1.stream().max((a,b)->a-b).get();
        System.out.println(r9);

        //10. Find minimum element in a list
        Integer r10=l1.stream().min((a,b)->a-b).get();
        System.out.println(r10);

       // 11. Find second highest number
        // distinct for duplicates number using sort method
         List<Integer> r11=l1.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
         Integer secondHighest=r11.get(1);
         System.out.println("this is 2nd 2nd highest number"+secondHighest);

         Integer secondHighestNumber1=l1.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
        System.out.println("this is 2nd 2nd highest number"+secondHighestNumber1);


        Integer secondHighestNumber2=l1.stream().distinct().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
        System.out.println("this is 2nd 2nd highest number"+secondHighestNumber2);

        Integer secondHighestNumber3=l1.stream().distinct().sorted(Comparator.reverseOrder()).reduce((a,b)->b).get();
        System.out.println("this is 2nd 2nd highest number"+secondHighestNumber3);

        //Approach	                                      Key Methods                    	    Notes
        //Sorted + Skip	                                  sorted().skip(1).findFirst()   	Cleanest & most common
        //Distinct + Sorted	                              distinct().sorted()	            Removes duplicates
        //Limit + Skip	                                  limit(2).skip(1)	                Works for top-N
        //Collect + Get                                   collect(Collectors.toList())	    Easier for debugging


        // 12. Find nth highest number

        List<Integer> r12=l1.stream().distinct().sorted().toList();
        System.out.println("this is nth highest number"+r12.get(5));

         int nthHighestNumber3 = r12.stream().distinct().sorted(Comparator.reverseOrder()).skip(5-1).findFirst().get();
   //skip first (n-1) elements
        System.out.println("this is nth highest number"+nthHighestNumber3);
  // // keep only top n elements

        List<Integer>nthHighestNumber4 = r12.stream().distinct().sorted(Comparator.reverseOrder()).limit(4).toList();
        System.out.println(nthHighestNumber4);
        System.out.println("this is nth highest number"+nthHighestNumber4.get(3));


       // 13. Count frequency of each character in a string
        String name="Shiva";
        HashMap<Character,Integer>map1=new HashMap<>();
        //names.stream().filter(a->!map1.containsKey(a))



        // 14. Count frequency of each word in a string

        String text = "Java is great and Java is powerful";
        Map<String, Long> wordCount = Arrays.stream(text.split("\\s+")) // split by spaces
                .collect(Collectors.groupingBy(
                        word -> word,              // key: each word
                        Collectors.counting()      // value: count of that word
                ));

        System.out.println(wordCount);

        List<String> sentences = Arrays.asList(
                "Java is great",
                "Java is powerful",
                "Streams are powerful"
        );
        Map<String, Long> wordCount1 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+"))) // flatten all words
                .collect(Collectors.groupingBy(
                        word -> word,               // key = word
                        Collectors.counting()       // value = count
                ));

        System.out.println(wordCount1);



        //  15. Group employees by department
      //  16. Partition numbers into even and odd
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);

        Map<Boolean,List<Integer> >  partitioned=numbers.stream().collect(Collectors.partitioningBy(num10->num10%2==0));

        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));
      //  17. Find all numbers starting with 1
       List<Integer>r17=  l1.stream().filter(a->String.valueOf(a).startsWith("1")).collect(Collectors.toList());
        System.out.println("Find all numbers starting with 1 :"+r17);

        // List<Integer> result = numbers.stream().filter(n -> (n + "").startsWith("1")).collect(Collectors.toList());

        // numbers.stream().filter(num -> String.valueOf(num).startsWith("1")).forEach(System.out::println);

      //  18. Sort a list of strings alphabetically and length both

        List<String> sorted = a1.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(sorted);


      //  19. Sort a list of strings by length

       // List<String>r19= a1.stream().sorted(Comparator.comparingInt((String::length))).toList() ;
         List<String>r19= a1.stream().sorted(Comparator.comparingInt((s->s.length()))).toList() ;

        System.out.println("reverse order sorted list"+r19);
       // 20. Sort numbers in descending order

        List<Integer>r20 =l1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("reverse order sorted list"+r20);

       // 21. Convert list of strings to uppercase

       List<String>r21= a1.stream().map(a->a.toUpperCase()).toList();
        System.out.println(r21);
      //  22. Convert list of strings to lowercase


       List<String>tolower= a1.stream().map(s->s.toLowerCase()).toList();
        System.out.println( "convert tolower case:" +tolower);

      //  23. Join strings with a delimiter
      String r23=a1.stream().reduce("",(a,b)->a+":"+b).toString();
        System.out.println("r23"+r23);

        String r231 = a1.stream()
                .collect(Collectors.joining(",")); // delimiter

        String r232 = a1.stream()
                .collect(Collectors.joining(", ", "[", "]"));
// [apple,amla,pumpkin ]
        //  24. Remove null values from a list
        List<String > r24= Arrays.asList("a",null,"b",null,"c");

       List<String>r241= r24.stream().filter(s->s!=null).toList();
        System.out.println( "remove null from the list:" +r241);




      //  25. Remove empty strings from a list
        List<String > r25= Arrays.asList("a","","b","","c");
        List<String>r251= r25.stream().filter(s -> !s.isEmpty()).toList();
        System.out.println( "remove empty string   from the list:" +r251);

        //26. Find sum of all numbers
       int sum= l1.stream().mapToInt(Integer::intValue).sum();

      int sum1= l1.stream().reduce(0,(a,b)->a+b);

      int sum2=l1.stream().collect(Collectors.summingInt(Integer::intValue));

       // 27. Find average of numbers
     Double r27= l1.stream().mapToInt(n->n).average().orElseThrow();
        System.out.println("this average of this list is "+r27);

     //   double average = numbers.stream()
       //         .collect(Collectors.averagingInt(n -> n));
//
        // 28. Convert list of numbers to set
             Set<Integer> set3= l1.stream().collect(Collectors.toSet());
        System.out.println("Convert list of numbers to set"+set3);

       // 29. Find employees with highest salary
        Employee e1=new Employee(14,600,"potatao");
        Employee e2=new Employee(15,800,"ladiesfinger");
        Employee e3=new Employee(17,1200,"coliflower");
        Employee e4=new Employee(18,1000,"cabbage");
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        //Employee highestSalEmployee=employeeList.stream().max(Comparator.comparingInt(Employee::getSalary)).orElse(null);
        Employee highestSalEmployee=employeeList.stream().max((e5,e6)-> {
            return Integer.compare(e5.getSalary(), e6.getSalary());
        }).orElseThrow(null);
        //System.out.println(highestSalEmployee);
        System.out.println(highestSalEmployee.getName());




       // 30. Find employees with lowest salary

         Employee lowestSalEmp=employeeList.stream().min(Comparator.comparingInt(Employee::getSalary)).orElse(null);


        //31. Group employees by salary range

      //  Map<Integer,List<Employee>> emp=employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));
        Map<Integer,List<Employee>> emp=employeeList.stream().collect(Collectors.groupingBy((emp1)->emp1.getSalary()));

     //   emp.forEach((salary,employeesList)->{
         //   System.out.println("Group employees by salary range :");
        //    System.out.println("salary "+salary);
        //    employeesList.forEach(System.out::println);
       //     });

        emp.forEach((salary,employeesList)->{
            System.out.println(salary+" "+employeesList);
        });

        Map<String, List<Employee>> empByRange = employeeList.stream()
                .collect(Collectors.groupingBy(emp2 -> {
                    double sal = emp2.getSalary();
                    if (sal < 600) return "Below 600";
                    else if (sal < 1000) return "600 - 1000";
                    else if (sal < 120000) return "1000 - 1500";
                    else return "Above 1500";
                }));

        empByRange.forEach((range, emps) -> {
            System.out.println(range + " => " + emps);
        });



        //  32. Find common elements between two lists
        List<String> list11 = Arrays.asList("A", "B", "C");
        List<String> list12 = Arrays.asList("D", "E", "F");
        List<String> common = list11.stream()
                .filter(list12::contains)
                .collect(Collectors.toList());


      //  33. Find elements present in one list but not in another


        List<String> r33=list11.stream().filter(e->!list12.contains(e)).toList();

        System.out.println("Find elements present in one list but not in another "+ r33);
      //  34. Merge two lists using streams
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "E", "F");
        List<String> mergedList= Stream.concat(list1.stream(),list2.stream()).toList();
        System.out.println("Merge two lists using streams"+ mergedList);


        // 35. Flatten a list of lists
        List<List<Integer>> listOfLists = new ArrayList<>();

        // Create inner lists
        List<Integer> lis = Arrays.asList(1, 2, 3);
        List<Integer> lis1 = Arrays.asList(4, 5, 6);
        List<Integer> lis2 = Arrays.asList(7, 8, 9);

        // Add to outer list
        listOfLists.add(lis);
        listOfLists.add(lis1);
        listOfLists.add(lis2);

       List<Integer> flattenList= listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Flatten a list of lists: "+flattenList);

       // List<Integer> flatList = listOfLists.stream()
         //       .flatMap(list -> list.stream())
           //     .collect(Collectors.toList());


        List<List<String>> nam = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David"),
                Arrays.asList("Eve", "Frank")
        );
        List<String> upperNames = nam.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperNames);
   //🔹 5️⃣ Remove Duplicates While Flattening

        List<Integer> unique11 = listOfLists.stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(unique);

        // //36. Limit and skip elements in a stream

       List<Integer>limList= l1.stream().limit(10).skip(2).toList();
        System.out.println("Limit and skip elements in a stream "+limList);




      //  37. Find palindrome strings from a list
        List<String> s2=Arrays.asList("madam","aba","hi");
       // s2.stream().filter(a->{a.replace()})
        //List<String> palindromes = words.stream()
        //    .filter(PalindromeFinder::isPalindrome)
        //    .collect(Collectors.toList());
        //
        //System.out.println(palindromes);
        //
        //...
        //
        //public static boolean isPalindrome(String str) {
        //    return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
        //}
        List<String> palindromes = s2.stream()
                .filter(word -> word.equalsIgnoreCase(
                        new StringBuilder(word).reverse().toString()))  // check palindrome
                .collect(Collectors.toList());

        System.out.println("Find palindrome strings from a list:"+ palindromes);


        // 38. Reverse sort a list of integers

        List<Integer> r38=l1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Reverse sort a list of integers:"+ r38);
       // 39. Reverse sort a list of strings

       List<String>r39= a1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Reverse sort a list of strings :"+r39);

      //  40. Generate first 10 prime numbers using streams
      //  41. Generate Fibonacci series using streams


       // 42. Find longest string in a list

        String r42=a1.stream().max(Comparator.comparingInt(a->a.length())).get();
        System.out.println("Find longest string in a list :"+r42);
       // 43. Find shortest string in a list

       // String s1=a1.stream().sorted(Comparator.comparingInt(a->a.length())).findFirst().get();
        String s1=a1.stream().min(Comparator.comparingInt(a->a.length())).get();
        System.out.println("Find shortest string in a list :"+s1);

        // String shortest = words.stream()
        //                       .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2)
        //                       .orElse(null);
        //
        //System.out.println("Shortest string: " + shortest);


       // 44. Find strings containing a particular substring

      List<String>r44=  a1.stream().filter(a->a.contains("pp")).toList();
        System.out.println("Find strings containing a particular substring"+r44);

       // 45. Count elements greater than a given value
       List<Integer> r45= l1.stream().filter(n->n>5).toList();
        System.out.println("Count elements greater than a given value"+r45);

       // 46. Convert list of integers to comma-separated string

      String r46=  l1.stream().map(a->a.toString()).collect(Collectors.joining(","));

      String stringList = l1.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println("Convert list of integers to comma-separated string"+r46);
       // 47. Check if all elements are unique in a list

       boolean allUnique=l1.stream().distinct().count()==l1.size();
        System.out.println("All elements unique? " + allUnique);

        boolean allUnique1 = l1.stream().collect(Collectors.toSet())  // collects unique elements
                .size() == l1.size();

        //Set<Integer> seen = new HashSet<>();
        //boolean hasDuplicate = numbers.stream()
        //                              .anyMatch(n -> !seen.add(n));
        //
        //System.out.println("Has duplicates? " + hasDuplicate);


       // 48. Check if any element matches a condition
       // 49. Check if all elements match a condition
       // 50. Check if no element matches a condition


    }
}

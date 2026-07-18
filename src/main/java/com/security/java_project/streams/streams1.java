package com.security.java_project.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streams1 {


    public static void main(String args[])
    {
        List<String> languages= Arrays.asList("English","Espaneol","Bengali","Hindi");
        List<String> outPutLanguages=languages.stream().filter( x->x.startsWith("E")).map(x->x.toUpperCase()).collect(Collectors.toList());
        System.out.println(outPutLanguages);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().sorted().forEach(System.out::println);

        list.stream().distinct().forEach(System.out::println);

        list.stream().limit(4).forEach(System.out::println);

      int result= list.stream().reduce((a,b)->a+b).get();
        System.out.println(result);

        List<List<Integer>> arraylist2d =Arrays.asList(
                Arrays.asList(1,2,3),
            Arrays.asList(4,5,6));

        List<Integer> result2darray=arraylist2d.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        System.out.println(result2darray);

    }

}

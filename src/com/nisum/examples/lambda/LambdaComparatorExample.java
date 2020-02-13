package com.nisum.examples.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sreeram Namani
 */

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23,45,65,21,9,18,53);
        System.out.println("Before Sorting : "+list );
        compareWithoutLambda(list);
        compareWitLambda(list);
    }

    private static void compareWithoutLambda(List<Integer> list) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Sorting Without using Lambda ");
        Collections.sort(list, comparator);
        System.out.println("After Sorting: " );
        /*for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }*/
        for (int i: list){
            System.out.println(i);
        }
        System.out.println("******************************* ");
    }

    private static void compareWitLambda(List<Integer> list) {
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        System.out.println("Sorting using Lambda ");
        Collections.sort(list, comparator);
        System.out.println("After Sorting: " );
        list.forEach(i -> System.out.println(i));
        System.out.println("******************************* ");
    }
}

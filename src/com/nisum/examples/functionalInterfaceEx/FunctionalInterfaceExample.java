package com.nisum.examples.functionalInterfaceEx;

@FunctionalInterface
interface Table{
    double sum(int a, int b);
    //void display(); //If you add another method it will throw exception
}
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Table table = (a, b) -> {return a+b;};
        double total = table.sum(10, 39);
        System.out.println(total);
    }
}

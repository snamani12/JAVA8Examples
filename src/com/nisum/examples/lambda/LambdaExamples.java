package com.nisum.examples.lambda;

/**
 * @author Sreeram Namani
 */

public class LambdaExamples {
    public static void main(String[] args) {
        runnableMethodWithoutLambda();
        runnableMethodWitLambda();

        //Using Annonymous inner class
        LambdaInterface lambdaInterface = new LambdaInterface() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        System.out.println("Using Annonymous inner class "+lambdaInterface.sum(12, 13));

        //Using Lambda Expression
        LambdaInterface lambdaInterface1 = (a, b) -> a+b;
        System.out.println("Using Lambda Expression "+lambdaInterface.sum(16, 13));
    }

    //Runnable Method calling usng anonymous inner class
    private static void runnableMethodWithoutLambda() {
        System.out.println("Calling....");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable method calling.... Without Lambda ");
            }
        };
        new Thread(r).start();
    }


    //Runnable Method calling usng Lambda Expression
    private static void runnableMethodWitLambda() {
        System.out.println("Calling....");
        Runnable r = () -> System.out.println("Runnable method calling.... With Lambda");
        new Thread(r).start();

    }

}

interface LambdaInterface{
    int sum(int a, int b);
}

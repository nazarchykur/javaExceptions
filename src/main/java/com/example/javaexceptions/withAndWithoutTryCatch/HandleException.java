package com.example.javaexceptions.withAndWithoutTryCatch;

public class HandleException {
    public static void main(String[] args) {
        HandleExceptionTryCatch handleExceptionTryCatch = new HandleExceptionTryCatch();
        handleExceptionTryCatch.someMethod();
        
        /*
         flow:
            start try catch
            going 1
            going 3
            handle error in catch block. Message = 10, Cause =  null
            going 4
            going 5
            finish try catch
         */

        DoNotHandleException doNotHandleException = new DoNotHandleException();
        doNotHandleException.someMethod();

        /*
        flow:
            start without try catch
            going 1
            going 2
            Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
                at com.example.javaexceptions.examples.DoNotHandleException.someMethod(HandleException.java:52)
                at com.example.javaexceptions.examples.HandleException.main(HandleException.java:21)
            ...    
         */
    }
}

class HandleExceptionTryCatch {
    public void someMethod() {
        // this block code handle exception
        System.out.println("start try catch");
        try {
            System.out.println("going 1");
            int[] array = new int[2];
            int doNotHaveThisIndex = array[10];
            System.out.println("going 2"); // will be skipped
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("going 3");
            System.out.println("handle error in catch block. Message = " + e.getMessage() + ", Cause =  " + e.getCause());
            System.out.println("going 4");
        }
        System.out.println("going 5");
        System.out.println("finish try catch");
    }
}

class DoNotHandleException {
    public void someMethod() {
        // this block code DO NOT handle exception
        System.out.println("start without try catch");
        System.out.println("going 1");
        int[] array = new int[2];
        System.out.println("going 2");
        int doNotHaveThisIndex = array[2]; //  here will throw ArrayIndexOutOfBoundsException
        System.out.println("going 3");  // code does not work further because has stopped the line above
        System.out.println("finish without try catch");
    }
}
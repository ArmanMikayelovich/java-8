package com.energizeglobal.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
  static      List<String> strings = new ArrayList<>();

    static {
        for (int x = 0; x < 1_000_000; x++) {
            strings.add(x / 1000 + "");
        }
    }

    public static void main(String[] args) {
        lambdaExpression();
        methodReference();
        threadInvoking();
        defaultMethod();
        peeking();
        badParallelStreams();
        badParallelStreams();
        badParallelStreams();
        trueParallelStream();

    }

    private static void trueParallelStream() {
        System.out.println("Good paralell stream");
        AtomicInteger[] wordLengths = new AtomicInteger[6];
        for (int x = 0; x < wordLengths.length; x++) {
            wordLengths[x] = new AtomicInteger(0);
        }
        strings.parallelStream().forEach(word -> wordLengths[word.length()].incrementAndGet());
        System.out.println(Arrays.toString(wordLengths));
    }

    private static void badParallelStreams() {
        System.out.println("Bad paralell Stream");

        int[] wordLengths = new int[5];
        strings.parallelStream().forEach(word -> wordLengths[word.length()]++);
        System.out.println(Arrays.toString(wordLengths));

    }

    private static void peeking() {
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();
        System.out.println(Arrays.toString(powers));
    }

    private static void defaultMethod() {
        System.out.println("Default method in interface");
        InterfaceWithDefaultMethod interfaceWithDefaultMethod = new InterfaceWithDefaultMethod() {
            @Override
            public int getId() {
                return 5;
            }
        };
        System.out.println(interfaceWithDefaultMethod.getName());

    }

    private static void threadInvoking() {
        class Greeting {
            public void greet() {
                System.out.println("Hi!");
            }
        }
        //if we using lambda expression or method reference,
        // we can use an class, that not implements Runnable or Callable...
        System.out.println("Thread invoking.");
        new Thread(new Greeting()::greet).start();
    }

    private static void lambdaExpression() {
        System.out.println("lambda expression example");

        int x = 5;
        final Optional<Integer> optionalX = Optional.of(x);
        optionalX.ifPresent(integer -> System.out.println(integer));
    }

    private static void methodReference() {
        System.out.println("method reference example");
        int x = 2;
        final Optional<Integer> optionalX = Optional.of(x);
        optionalX.ifPresent(System.out::println);
        Arrays.sort(new int[]{1, 2, 3});
    }
}

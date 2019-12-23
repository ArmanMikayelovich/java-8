package com.energizeglobal.internship;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayList2<E> extends ArrayList {
    void forEachIf(Consumer<E> action, Predicate<E> filter) {
        Objects.requireNonNull(action);
        Objects.requireNonNull(filter);
        final int size = this.size();
        for (Object o : this) {
            E object = (E) o;
            if (filter.test((E) o)) {
                action.accept((E) o);
            }
        }
    }

    public static void main(String[] args) {
        final ArrayList2<Integer> integerArrayList2 = new ArrayList2<>();
        integerArrayList2.add(2);
        integerArrayList2.add(3);
        integerArrayList2.add(4);
        integerArrayList2.add(5);
        integerArrayList2.add(94);
        integerArrayList2.add(245);
        integerArrayList2.add(123);
        integerArrayList2.forEachIf(System.out::println, x -> x > 100);
    }




}

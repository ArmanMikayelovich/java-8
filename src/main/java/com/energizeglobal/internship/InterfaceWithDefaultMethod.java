package com.energizeglobal.internship;

public interface InterfaceWithDefaultMethod {
    int getId();

    default String getName() {
        System.err.println("Need an implementation.");
        return null;
    }

}

package com.energizeglobal.internship;

public interface Person {
    default String getName() {
        return String.valueOf(this.hashCode());
    }
}

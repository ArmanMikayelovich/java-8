package com.energizeglobal.internship;

import org.w3c.dom.NamedNodeMap;

public class Human implements Person, StandardNamed {
    //if we have 2 or more interfaces which have same method's different default implementation,
    //we have to override the method in each implementation.
    @Override
    public String getName() {
        return "new Carter";
    }
}

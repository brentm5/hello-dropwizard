package com.bmontague.helloworld.models;

/**
 * Created by bmontague on 6/2/17.
 */
public class Hello {

    private String Name;

    public Hello(){
        this("");
    }

    public Hello(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }
}

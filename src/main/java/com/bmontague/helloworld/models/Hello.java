package com.bmontague.helloworld.models;

import io.opentracing.contrib.agent.Trace;

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

    @Trace
    public String getName() {
        try { Thread.sleep(1200); } catch (InterruptedException e) {}

        return Name;
    }
}

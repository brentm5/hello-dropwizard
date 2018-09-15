package com.bmontague.helloworld.tasks;

import com.google.common.collect.ImmutableMultimap;
import datadog.trace.api.Trace;
import io.dropwizard.servlets.tasks.Task;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.PrintWriter;

/**
 * Created by bmontague on 10/16/15.
 */
public class HelloTask extends Task{

    private static final Logger LOG = LoggerFactory.getLogger(HelloTask.class);

    public HelloTask() {
        super("hello");
    }

    @Override
    @Trace
    public void execute(ImmutableMultimap<String, String> immutableMultimap, PrintWriter printWriter) throws Exception {
        LOG.debug("Running the Hello Task for fun");
        if (immutableMultimap.containsKey("name")) {
            printWriter.printf("Hello World, %s", immutableMultimap.get("name"));
        }
    }
}

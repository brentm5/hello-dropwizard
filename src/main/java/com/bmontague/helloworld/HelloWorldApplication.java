package com.bmontague.helloworld;

import com.bmontague.helloworld.commands.HelloCommand;
import com.bmontague.helloworld.healthchecks.HelloCheck;
import com.bmontague.helloworld.tasks.HelloTask;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.bmontague.helloworld.resources.HelloWorldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addCommand(new HelloCommand());
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        environment.admin().addTask(new HelloTask());
        environment.healthChecks().register("hello", new HelloCheck());
        environment.jersey().register(new HelloWorldResource(configuration.getName()));
    }

}

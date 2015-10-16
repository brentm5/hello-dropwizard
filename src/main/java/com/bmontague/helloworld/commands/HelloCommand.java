package com.bmontague.helloworld.commands;

import io.dropwizard.cli.Command;
import io.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by bmontague on 10/16/15.
 */
public class HelloCommand extends Command {

    private static final Logger LOG = LoggerFactory.getLogger(HelloCommand.class);

    public HelloCommand() {
        super("hello", "I just want to say hello");
    }

    @Override
    public void configure(Subparser subparser) {
        subparser.addArgument("-a", "--action")
                .setDefault("hello")
                .help("The action to perform [hello,goodbye]");
        subparser.addArgument("names")
                .nargs("*")
                .required(true)
                .help("<Names> The names to say hello To");
    }

    @Override
    public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
        LOG.debug("Here we run the command");
        List<String> names = namespace.getList("names");
        if (!names.isEmpty()) {
            for(String name : names) {
                System.out.printf("Hello there %s!", name);
                System.out.println();
            }
        }
    }
}

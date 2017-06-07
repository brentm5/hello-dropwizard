package com.bmontague.helloworld.healthchecks;


import com.codahale.metrics.health.HealthCheck;
import io.opentracing.contrib.agent.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bmontague on 10/16/15.
 */
public class HelloCheck extends HealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(HelloCheck.class);

    @Override
    protected Result check() throws Exception {
        LOG.debug("Check is healthy");
        return Result.healthy("Hello!");
    }
}

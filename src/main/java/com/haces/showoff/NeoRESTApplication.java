package com.haces.showoff;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NeoRESTApplication extends Application<NeoRESTConfiguration> {

    public static void main(final String[] args) throws Exception {
        new NeoRESTApplication().run(args);
    }

    @Override
    public String getName() {
        return "NeoREST";
    }

    @Override
    public void initialize(final Bootstrap<NeoRESTConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final NeoRESTConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}

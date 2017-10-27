package com.haces.showoff;

import com.haces.showoff.health.TemplateHealthCheck;
import com.haces.showoff.resources.NeoRESTResource;

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
  public void run(final NeoRESTConfiguration configuration, final Environment environment) {
    final NeoRESTResource resource = new NeoRESTResource(configuration.getTemplate(), configuration.getDefaultName());
    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }

}

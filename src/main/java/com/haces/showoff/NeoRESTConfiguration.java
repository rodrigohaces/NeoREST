package com.haces.showoff;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NeoRESTConfiguration extends Configuration {
  @NotEmpty
  String neo4jURI;

  @NotEmpty
  String neo4jUsername;

  @NotEmpty
  String neo4jPassword;

  @JsonProperty
  public String getNeo4jURI() {
    return neo4jURI;
  }

  @JsonProperty
  public void setNeo4jURI(String neo4jURI) {
    this.neo4jURI = neo4jURI;
  }

  @JsonProperty
  public String getNeo4jUsername() {
    return neo4jUsername;
  }

  @JsonProperty
  public void setNeo4jUsername(String neo4jUsername) {
    this.neo4jUsername = neo4jUsername;
  }

  @JsonProperty
  public String getNeo4jPassword() {
    return neo4jPassword;
  }

  @JsonProperty
  public void setNeo4jPassword(String neo4jPassword) {
    this.neo4jPassword = neo4jPassword;
  }
}

package com.haces.showoff.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
  private int id;

  private String name;

  public Employee() {

  }

  public Employee(int employeeID, String employeeName) {
    this.id = employeeID;
    this.name = employeeName;
  }

  @JsonProperty
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

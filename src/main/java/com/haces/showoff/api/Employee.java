package com.haces.showoff.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
  private int employeeID;
  private String employeeName;
  
  public Employee () {
    
  }
  
  public Employee(int employeeID, String employeeName) {
    this.employeeID = employeeID;
    this.employeeName = employeeName;
  }
  
  @JsonProperty
  public int getEmployeeID() {
    return employeeID;
  }
  
  public String getEmployeeName() {
    return employeeName;
  }
}

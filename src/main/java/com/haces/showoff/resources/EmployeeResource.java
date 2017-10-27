package com.haces.showoff.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import com.haces.showoff.api.Employee;

@Path("/Employee")
public class EmployeeResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/List")
  public List<Employee> list() {
    List<Employee> employees = new ArrayList<Employee>();

    // Replace below with implementation to get Employees from neo4j
    employees.add(new Employee(5, "Rodrigo Haces"));
    employees.add(new Employee(6, "Employee 6"));
    employees.add(new Employee(7, "New Employee 7"));
    employees.add(new Employee(8, "Old Employee 8"));
    // 

    return employees;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/Add")
  public Employee add(@QueryParam("id") int employeeID, @QueryParam("name") String employeeName) {
    // Add implementation to add Employee to neo4j
    
    return new Employee(employeeID, employeeName);
  }
}

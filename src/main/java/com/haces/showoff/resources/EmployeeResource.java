package com.haces.showoff.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import com.haces.showoff.api.Employee;
import com.haces.showoff.db.NeoDB;

@Path("/Employee")
public class EmployeeResource {
  private final String neo4jURI;

  private final String neo4jUsername;

  private final String neo4jPassword;

  public EmployeeResource(String neo4jURI, String neo4jUsername, String neo4jPassword) {
    this.neo4jURI = neo4jURI;
    this.neo4jUsername = neo4jUsername;
    this.neo4jPassword = neo4jPassword;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/List")
  public List<Employee> list() {

    NeoDB neoDB = new NeoDB(neo4jURI, neo4jUsername, neo4jPassword);
    List<Employee> employees = neoDB.getEmployees();
    neoDB.close();
    return employees;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/Add")
  public Employee add(@QueryParam("id") int employeeID, @QueryParam("name") String employeeName) {

    NeoDB neoDB = new NeoDB(neo4jURI, neo4jUsername, neo4jPassword);
    Employee employee = neoDB.addEmployee(employeeID, employeeName);
    neoDB.close();
    return employee;
  }
}

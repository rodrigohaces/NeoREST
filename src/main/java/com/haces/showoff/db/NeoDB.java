package com.haces.showoff.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.types.Node;

import com.haces.showoff.api.Employee;

public class NeoDB {
  Driver driver;

  public NeoDB(String uri, String user, String password) {
    driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
  }

  public List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList<Employee>();
    Session session = driver.session();
    StatementResult result = session.run("MATCH (n:Employee) RETURN n.id, n.name LIMIT 25");

    while (result.hasNext()) {
      Record record = result.next();
      employees.add(new Employee(record.get("n.id").asInt(), record.get("n.name").asString()));
    }
    return employees;
  }

  public Employee addEmployee(int id, String name) {
    Employee employee = new Employee(id, name);

    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("name", name);

    try (Session session = driver.session()) {
      try (Transaction tx = session.beginTransaction()) {
        tx.run("CREATE (:Employee {id:$id, name:$name})", params);
        tx.success();
      } catch (Exception e) {
        System.out.println("Exception " + e.toString());
      }
    } catch (Exception e) {
      System.out.println("Exception " + e.toString());
    }
    return employee;
  }

  public void close() {
    driver.close();
  }
}

package edu.neu.springboot.cruddemo.controller;

import edu.neu.springboot.cruddemo.entity.Employee;
import edu.neu.springboot.cruddemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private final EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee findById(@PathVariable Long employeeId) {
    Employee employee = employeeService.findById(employeeId);
    if (employee == null) {
      throw new RuntimeException("Employee id not found.");
    }
    return employee;
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);
    return employee;
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable Long employeeId) {
    Employee employee = employeeService.findById(employeeId);
    if (employee == null) {
      throw new RuntimeException("Employee id not found.");
    }
    employeeService.delete(employeeId);
    return "Deleted employee id - " + employeeId;
  }
}

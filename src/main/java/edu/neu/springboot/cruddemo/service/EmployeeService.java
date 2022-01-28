package edu.neu.springboot.cruddemo.service;

import edu.neu.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(Long id);

  void save(Employee employee);

  void delete(Long employeeId);
}

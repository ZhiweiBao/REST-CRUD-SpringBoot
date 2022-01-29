package edu.neu.springboot.cruddemo.service.impl;

import edu.neu.springboot.cruddemo.dao.EmployeeRepository;
import edu.neu.springboot.cruddemo.entity.Employee;
import edu.neu.springboot.cruddemo.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {
    Optional<Employee> result = employeeRepository.findById(id);
    Employee employee;
    if (result.isPresent()) {
      employee = result.get();
    } else {
      throw new RuntimeException("Employee id not found - " + id);
    }
    return employee;
  }

  @Override
  public void save(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public void delete(Long employeeId) {
    employeeRepository.deleteById(employeeId);
  }
}

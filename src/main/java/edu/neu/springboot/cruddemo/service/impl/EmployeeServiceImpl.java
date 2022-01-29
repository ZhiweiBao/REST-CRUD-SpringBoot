package edu.neu.springboot.cruddemo.service.impl;

import edu.neu.springboot.cruddemo.dao.EmployeeDAO;
import edu.neu.springboot.cruddemo.entity.Employee;
import edu.neu.springboot.cruddemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(
      @Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  @Transactional
  public Employee findById(Long id) {
    return employeeDAO.findById(id);
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    employeeDAO.save(employee);
  }

  @Override
  @Transactional
  public void delete(Long employeeId) {
    employeeDAO.delete(employeeId);
  }
}

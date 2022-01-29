package edu.neu.springboot.cruddemo.dao.impl;

import edu.neu.springboot.cruddemo.dao.EmployeeDAO;
import edu.neu.springboot.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

  private final EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    Query query = entityManager.createQuery("from Employee");
    return (List<Employee>) query.getResultList();
  }

  @Override
  public Employee findById(Long id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Employee employeeFromDB = entityManager.merge(employee);
    employee.setId(employeeFromDB.getId());
  }

  @Override
  public void delete(Long employeeId) {
    Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId", employeeId);
    query.executeUpdate();
  }
}

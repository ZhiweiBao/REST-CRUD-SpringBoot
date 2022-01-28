package edu.neu.springboot.cruddemo.dao.impl;

import edu.neu.springboot.cruddemo.dao.EmployeeDAO;
import edu.neu.springboot.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  private final EntityManager entityManager;

  @Autowired
  public EmployeeDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee findById(Long id) {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }

  @Override
  public void delete(Long employeeId) {
    Session session = entityManager.unwrap(Session.class);
    Query query = session.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId", employeeId);
    query.executeUpdate();
  }
}

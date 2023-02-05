package com.amanpreet.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amanpreet.springrest.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("fromEmployee", Employee.class);
		List<Employee> employee = query.getResultList();
		return null;
	}
	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}
	@Override
	public void insert(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employee);
	}
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from employee where id = :employeeid");
		query.setParameter("employeeid",id);
		query.executeUpdate();
	}
}

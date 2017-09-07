package uc.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uc.cs.entity.Employee;
import uc.cs.exception.BadRequestException;
import uc.cs.exception.ResourceNotFoundException;
import uc.cs.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findOne(String id) {
        return repository.findOne(id);

    }

    @Transactional
    public Employee create(Employee emp) {
/*
        if (repository.findByEmail(emp.getEmail()) != null) {
            throw new BadRequestException("Employee with email " + emp.getEmail() + " already exists.");
        }
*/
        return repository.save(emp);
    }

    @Transactional
    public Employee update(String id, Employee emp) {

        if (repository.findOne(id) == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return repository.save(emp);
    }

    @Transactional
    public void delete(String id) {

        if (repository.findOne(id) == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        repository.delete(repository.findOne(id));
    }
}
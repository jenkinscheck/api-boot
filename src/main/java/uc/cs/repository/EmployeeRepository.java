package uc.cs.repository;

import org.springframework.data.repository.Repository;
import uc.cs.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository  extends Repository<Employee,String> {

    public List<Employee> findAll();

    public Employee findOne(String id);

    public Optional<Employee> findByEmail(String email);

    public Employee save(Employee emp);

    void delete(Employee emp);
}

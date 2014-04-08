package co.id.service;

import co.id.model.Employee;
import java.util.List;

/**
 * @author tombisnis@yahoo.com
 */
public interface EmployeeService {
    public void save(Employee employee);
    public void update(Employee employee);
    public void delete(Employee employee);
    public List<Employee> getAllEmployees();
}
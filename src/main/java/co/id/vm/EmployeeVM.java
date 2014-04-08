package co.id.vm;

import java.util.List;

import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import co.id.model.Employee;
import co.id.service.EmployeeService;

/**
 * @author tombisnis@yahoo.com
 */
public class EmployeeVM {
	private Employee employee;
	private List<Employee> employees;
	@WireVariable
	private EmployeeService employeeService;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Init
	public void initComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("employee") Employee employee) {
		
		Selectors.wireComponents(component, this, false);
		String windowID = (String) object;

		if (windowID == "windowDialog") {
			
			if(employee == null){
				
				this.employee = new Employee();
			}else {
				
				this.employee = employee;
			}
		}else {
			
			employees = employeeService.getAllEmployees();
		}
	}
}

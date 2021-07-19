package Task2Stream;

import java.util.List;

public class Repository {
	private static EmployeeDB employeeDB;

	public Repository() {
		employeeDB = new EmployeeDB();
	}

	public void insertData(Employee emp) {
		employeeDB.getEmployeesList().add(emp);
	}

	public List<Employee> getEmployeeList() {
		return employeeDB.getEmployeesList();
	}

	public List<Employee> deleteEmployee() {
		return employeeDB.getEmployeesList();
	}
}

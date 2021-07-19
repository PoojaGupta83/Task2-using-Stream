package Task2Stream;

import java.util.*;

public class Employee implements Comparable<Employee> {
	Integer empId;
	String empName;
	Integer salary;
	String dept;

	public Employee(Integer empId, String empName, Integer salary, String dept) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.dept = dept;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public String getDept() {
		return dept;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "{" + empId + ", " + "'" + empName + "'" + "," + salary + "," + "'" + dept + "'" + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		Employee employee = (Employee) o;
		if ((employee.empId == this.empId) && (employee.empName == this.empName) && (employee.salary == this.salary)
				&& employee.dept == dept)
			;
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, salary, dept);
	}

	@Override
	public int compareTo(Employee employee) {
		return this.empId - employee.empId;
	}

}

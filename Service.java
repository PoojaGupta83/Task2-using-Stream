package Task2Stream;

import java.util.*;
import Task2Stream.Employee;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Service {

	private Repository repo;

	public Service() {
		repo = new Repository();

	}

	/* "1. Print Employee List" */
	public void showList() {

		List<Employee> empl = repo.getEmployeeList();
		for (Employee emp2 : empl) {
			System.out.println(emp2);
		}
	}

	/* "2. Print Employee List in Sorting Order" */

	public void SortedEmployeeList() {

		List<Employee> emp = repo.getEmployeeList();
		Collections.sort(emp);
		for (Employee emp1 : emp) {
			System.out.println(emp1);
		}
	}

	/* "3. Print all the unique Employee" */

	public Map<Integer, Employee> UniqueDetail() {

		List<Employee> empl = repo.getEmployeeList();
		Map<Integer, Employee> map = new HashMap<>();

		for (Employee e1 : empl) {
			map.put(e1.empId, e1);
		}
		return map;
	}

	/* 4. Print all the unique Employee By Sorting */

	public void UniqueSorted() {
		Service eService = new Service();
		Map<Integer, Employee> map = eService.UniqueDetail();
		List<Employee> emps = new ArrayList<>(map.values());
		Collections.sort(emps, new NameComp());
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	/* 5. Print Employee details by EmpId " */

	public boolean DetailByID(Integer empId) {

		List<Employee> empl = repo.getEmployeeList();
		Employee employee = new Employee();
		boolean check = false;
		for (Employee e1 : empl) {
			if (e1.getEmpId().equals(empId)) {
				check = true;
				System.out.println(e1.getEmpId() + " , " + e1.getEmpName() + " , " + e1.getSalary());
			}
		}
		return check;
	}

	/* 6. Print Employee details by Salary */

	public void EmployeeDetailsBySalary() {

		List<Employee> empList = repo.getEmployeeList();
		Collections.sort(empList, new SalaryComp());
		System.out.println("Sorted List Entries by Salary");
		for (Employee e : empList) {
			System.out.println(e.empId + " " + e.empName + " " + e.salary + " " + e.dept);
		}
	}

	/* 7. Insert New Employee */

	public void addEmployee(Employee employee) {
		repo.insertData(employee);
	}

	/* 8 Retrieve and Update Employee Detail */

	public List<Employee> getEmployeeDetail() {
		List<Employee> empl = repo.getEmployeeList();
		return empl;
	}

	/* 9 Delete Employee by Id */

	public boolean deleteEmployee(int empId) {
		boolean check = false;
		List<Employee> list = repo.deleteEmployee();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmpId().equals(empId)) {
				check = true;
				list.remove(i);

			}
		}
		return check;

	}
	/* 10 Print all Employee name in uppercase */

	public void printAllEmployeeNameUpperCase() {
		List<Employee> emList = repo.getEmployeeList();
		List<String> name = (List<String>) emList.stream().map(employee -> employee.getEmpName().toUpperCase())
				.collect(Collectors.toList());
		// .forEach(System.out::println);
		System.out.println(name);

	}

	/* 11 Print All Employees Salary Above Input Salary */
	public void printAllEmployeesSalaryGreaterThanGivenSalary(int salary1) {
		List<Employee> employess = repo.getEmployeeList();
		List<Employee> employeesSalary = employess.stream().filter(emp -> emp.getSalary() > salary1)
				.collect(Collectors.toList());
		System.out.println(employeesSalary);
	}
	/* 12 Print Total,Average,Maximum and Minimum Salary of Employees */

	/* Total Salary */
	public void Total_Salary() {
		List<Employee> employess = repo.getEmployeeList();
		int total = employess.stream().mapToInt(Employee::getSalary).sum();
		System.out.println("Total Salary Of Employees=" + total);
		// return total;
	}

	/* Average Salary */

	public void Average_Salary() {
		List<Employee> employess = repo.getEmployeeList();
		// employeeRepository.getEmployeeList();
		OptionalDouble average = employess.stream().mapToInt(Employee::getSalary).average();
		System.out.println("Average Salary of Employees=" + average);
	}

	/* Maximum Salary */

	public void Max_Salary() {
		List<Employee> employess = repo.getEmployeeList();
		OptionalInt max = employess.stream().mapToInt(Employee::getSalary).max();
		System.out.println("Maximum Salary of Emplyoees=" + max);

	}

	/* Minimum Salary */

	public void Min_Salary() {
		List<Employee> employess = repo.getEmployeeList();
		OptionalInt min = employess.stream().mapToInt(Employee::getSalary).min();
		System.out.println("Minimum Salary of Employees=" + min);

	}

	/*
	 * 12 Print Total,Average,Maximum and Minimum Salary of Employees Department
	 * wise
	 */

	/* Total salary Department wise */

	public void TotalSalaryDeptwise(String dept_name) {

		List<Employee> employess = repo.getEmployeeList();
		int total_Dept_Salary = employess.stream().filter(employee -> employee.getDept().equals(dept_name))
				.mapToInt(Employee::getSalary).sum();
		System.out.println("Total salary Department wise=" + total_Dept_Salary);
	}

	/* Average Salary Department wise */

	public void AverageSalaryDeptwise(String dept_name) {

		List<Employee> employess = repo.getEmployeeList();
		OptionalDouble avg_Dept_Salary = employess.stream().filter(employee -> employee.getDept().equals(dept_name))
				.mapToInt(Employee::getSalary).average();
		System.out.println("Average salary Department wise=" + avg_Dept_Salary);

	}

	/* Maximum Salary Department wise */

	public void MaxSalaryDeptwise(String dept_name) {

		List<Employee> employess = repo.getEmployeeList();
		OptionalInt Max_Dept_Salary = employess.stream().filter(employee -> employee.getDept().equals(dept_name))
				.mapToInt(Employee::getSalary).max();
		System.out.println("Maximum salary Department wise=" + Max_Dept_Salary);

	}

	/* Minimum Salary Department wise */

	public void MinSalaryDeptwise(String dept_name) {

		List<Employee> employess = repo.getEmployeeList();
		OptionalInt Min_Dept_Salary = employess.stream().filter(employee -> employee.getDept().equals(dept_name))
				.mapToInt(Employee::getSalary).min();
		System.out.println("Minimum salary Department wise=" + Min_Dept_Salary);

	}

}

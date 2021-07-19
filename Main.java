package Task2Stream;

import java.util.*;

import Task2Stream.Service;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Details");
		System.out.println("1. Print Employee List");
		System.out.println("2. Print Employee List in Sorting Order");
		System.out.println("3. Print all the unique Employee");
		System.out.println("4. Print all the unique Employee By Sorting");
		System.out.println("5. Print Employee details by EmpId ");
		System.out.println("6. Print Employee List by Salary ");
		System.out.println("7. Insert New  Employee");
		System.out.println("8. Retrieve and Update Employee Details ");
		System.out.println("9. Delete Employee Details");
		System.out.println("10.Employee Name in upper case");
		System.out.println("11.Print All Employees Salary Greater Than Input");
		System.out.println("12.Print Total,Average,Minimum ,Maximum Salary");
		System.out.println("13.Print Total,Average,Minimum ,Maximum Salary Department Wise");
		System.out.println("14. Exit");

		Service service = new Service();
		System.out.println("Enter the option");

		while (true) {
			int option = sc.nextInt();
			switch (option) {
			case 1:
				service.showList();
				break;
			case 2:
				service.SortedEmployeeList();

			case 3:
				System.out.println(service.UniqueDetail());
				break;

			case 4:
				service.UniqueSorted();
				break;

			case 5:
				System.out.println("Enter employee id");
				Integer o = sc.nextInt();
				service.DetailByID(o);
				break;

			case 6:
				service.EmployeeDetailsBySalary();
				break;

			case 7:
				System.out.println("Enter New Employee Id:");
				int empId = sc.nextInt();
				System.out.println("Enter New Employee Name:");
				String empName = sc.next();
				System.out.println("Enter Employee Salary");
				int salary = sc.nextInt();
				System.out.println("Enter Employee Department Name");
				String dept = sc.next();
				Employee employee = new Employee(empId, empName, salary, dept);
				service.addEmployee(employee);
				break;

			case 8:
				List<Employee> emp = service.getEmployeeDetail();
				System.out.println(emp);
				break;

			case 9:
				System.out.println("Enter Employee Id");
				Integer empId1 = sc.nextInt();
				boolean check = service.deleteEmployee(empId1);
				if (!check) {
					System.out.println("Employee not exist");
				}

				break;

			case 10:
				service.printAllEmployeeNameUpperCase();
				break;

			case 11:
				System.out.println("Enter the salary");
				int salary1 = sc.nextInt();
				service.printAllEmployeesSalaryGreaterThanGivenSalary(salary1);
				break;

			case 12:

				service.Total_Salary();
				service.Average_Salary();
				service.Max_Salary();
				service.Min_Salary();
				break;

			case 13:
				System.out.println("Enter department name");
				String dept_name = sc.next();
				service.TotalSalaryDeptwise(dept_name);
				service.AverageSalaryDeptwise(dept_name);
				service.MaxSalaryDeptwise(dept_name);
				service.MinSalaryDeptwise(dept_name);
				break;

			case 14:
				System.out.println("Exit");
				break;

			}
		}
	}

}
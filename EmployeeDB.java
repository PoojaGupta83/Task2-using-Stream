package Task2Stream;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
	private List<Employee> eList;
	private static EmployeeDB instance = null;

	public EmployeeDB() {
		eList = new ArrayList<>();
		eList.add(new Employee(1001, "Raman", 10000, "HR"));
		eList.add(new Employee(1002, "Rohit", 20000, "Sales And Marketing"));
		eList.add(new Employee(1003, "Manoj", 12000, "Infrastructure"));
		eList.add(new Employee(1004, "Amit", 12000, "Product Development"));
		eList.add(new Employee(1005, "Kabit", 11500, "HR"));
		eList.add(new Employee(1006, "Laxam", 11500, "Account And Finance"));
		eList.add(new Employee(1007, "Dipesh", 10000, "Product Development"));
		eList.add(new Employee(1008, "Amit", 10000, "Sales And Marketing"));
		eList.add(new Employee(1009, "Manoj", 17500, "Infrastructure"));
		eList.add(new Employee(1010, "Rohit", 21000, "Product Development"));
		eList.add(new Employee(1003, "Manoj", 15000, "Account And Finance"));
		eList.add(new Employee(1002, "Rohit", 20000, "Sales And Marketing"));
	}

	public static EmployeeDB getInstance() {
		synchronized (EmployeeDB.class) {
			if (instance == null) {
				instance = new EmployeeDB();
			}
			return instance;
		}
	}

	public List<Employee> getEmployeesList() {
		return eList;
	}
}

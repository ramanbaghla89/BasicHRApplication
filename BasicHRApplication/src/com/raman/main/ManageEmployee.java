package com.raman.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.raman.data.EmployeeDAOImp;
import com.raman.data.UserDAOImpl;
import com.raman.model.Employee;
import com.raman.model.User;
public class ManageEmployee {
		static Scanner scanner=null;
	static EmployeeDAOImp employeeUtil;
	static UserDAOImpl userUtil;
	static {
		scanner=new Scanner(System.in);
		employeeUtil=new EmployeeDAOImp();
		userUtil = new UserDAOImpl();
		
	}
	
	public static void main(String[] args) {
		
		do {
			try {
				System.out.println("\n********MAIN MENU********");
				System.out.println("1. Login");
				System.out.println("2. New user registration");
				System.out.println("3. Exist");
				
				System.out.println("Enter youe option");
				int i=scanner.nextInt();
				switch(i) {
				case 1:
					authUser();
					   break;
				case 2:
					saveUer();
					   break;
				case 3:
					System.out.println("*****Thanks for using HR Applications*****");
					   System.exit(0);
					   default:
						   System.out.println("please enter a valid key");
				       break;
				}
			}catch(Exception e){
				
				System.out.println(e.getMessage());		
				
				
			}
		}while(true);
	
	}
	
	private static void saveUer() {
		
				System.out.println("User Id: ");
				String userID = scanner.next();
				System.out.println("Password");
				String password = scanner.next();
				System.out.println("First Name ");
				String firstName = scanner.next();
				System.out.println("Last Name");
				String lastName = scanner.next();
				System.out.println("Address ");
				String Address = scanner.next();
				System.out.println("city");
				String city = scanner.next();
				System.out.println("Country: ");
				String country = scanner.next();
				
				User user = new User(userID, password,firstName,lastName,Address,city,country);
				try {
					userUtil.addUser(user);
					System.out.println("User Registered Successfully");
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
		
	}

	private static void authUser() {
		// TODO Auto-generated method stub
		System.out.println("User Id: ");
		String userId = scanner.next();
		System.out.println("Password");
		String password = scanner.next();
		try {
			User user = userUtil.getUser(userId);
			if(user.getPassword().equals(password)) {
		do {
			System.out.println("\n********Hello: "+ user.getFirstName().toUpperCase());
			System.out.println("1. Add Employee");
			System.out.println("2. Print Employee Details");
			System.out.println("3. Search Employees By Name");
			System.out.println("4. View Employee Details By ID");
			System.out.println("5. Remove Employee");
			System.out.println("6. Change Employee Salary");
			System.out.println("7. Change Employee Designation");
			System.out.println("8. Back to home");
			
			
			System.out.println("Enter your option");
			int i=scanner.nextInt();
			switch(i) {
			case 1:addEmployee();
				   break;
			case 2:printEmployeeDetails();
				   break;
			case 3:searchEmployeesByName();
			       break;
			case 4:viewEmployeeDetailsByID();
			       break;
			case 5:removeEmployee();
			       break;
			case 6:changeEmployeeSalary();
				   break;
			case 7:changeEmployeeDesignation();
				   break;
			case 8:
				return;
				   default:
					   System.out.println("please enter a valid key");
		}
		}while(true);
		
	}else {
		System.out.println("Wrong Password try again");
	}
}catch(Exception e){
	
	System.out.println(e.getMessage());					

}
}
	
	private static void changeEmployeeDesignation() {
		System.out.println("ID");
		int id= scanner.nextInt(); 
		System.out.println("First Name");
		String firstName= scanner.next(); 
		System.out.println("Last Name");
		String lastName= scanner.next();
		System.out.println("Email");
		String email=scanner.next();		
		System.out.println("Department");
		String department=scanner.next();
		System.out.println("Salary");
		double salary=scanner.nextDouble();
		
		
		Employee emp=new Employee(firstName,lastName,email,department,salary);
				try {
					employeeUtil.updateEmployee(emp);
					System.out.println("Record inserted successfully");
				}
		catch(Exception e) {
			System.out.println(e.getMessage());
				}
		
			}

	private static void removeEmployee() {
		System.out.println("ID");
		int id= scanner.nextInt();
		
						try {
							employeeUtil.deleteEmployee(id);
							System.out.println("Successfully Changed\n");
							
							}
		catch(Exception e) {
			System.out.println(e.getMessage());
				}
	}

	private static void changeEmployeeSalary() {
		// TODO Auto-generated method stub
		System.out.println("ID");
		int id= scanner.nextInt();
		System.out.println("Updated Salary");
		double salary= scanner.nextDouble();

		try {
			employeeUtil.updateSalary(id, salary);
			System.out.println("Successfully Changed\n");
}
catch(Exception e) {
System.out.println(e.getMessage());
}
		
	}

	private static void viewEmployeeDetailsByID() {
		System.out.println("ID");
		int id= scanner.nextInt();
		
						try {
							Employee emp = employeeUtil.findById(id);
							System.out.println(emp);
				}
		catch(Exception e) {
			System.out.println(e.getMessage());
				}
		
	}	

	private static void searchEmployeesByName() {
		System.out.println("Name");
		String name= scanner.next();
		
						try {
							ArrayList<Employee> employeeList= (ArrayList<Employee>) employeeUtil.findByName(name);
							for( Employee emp : employeeList) {
								System.out.println(emp);
							}
				}
		catch(Exception e) {
			System.out.println(e.getMessage());
				}
		

	}

	private static void printEmployeeDetails() {
		try {
			List<Employee> employeesList=employeeUtil.findAll();
			for(Employee emp : employeesList) {
				System.out.println(emp);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addEmployee(){
		System.out.println("First Name");
		String firstName= scanner.next(); 
		System.out.println("Last Name");
		String lastName= scanner.next();
		System.out.println("Email");
		String email=scanner.next();		
		System.out.println("Department");
		String department=scanner.next();
		System.out.println("Salary");
		double salary=scanner.nextDouble();
		
		Employee emp=new Employee(firstName,lastName,email,department,salary);
				try {
					employeeUtil.addEmployee(emp);
					System.out.println("Record inserted successfully");
				}
		catch(Exception e) {
			System.out.println(e.getMessage());
				}
		
	}	
		
	}


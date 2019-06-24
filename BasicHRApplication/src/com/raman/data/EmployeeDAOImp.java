package com.raman.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.raman.model.Employee;

public  class EmployeeDAOImp implements EmployeeDAO{

	@Override
	public void addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("insert Employees(first_name,last_name,email,department,salary)values(?,?,?,?,?)");
			ps.setString(1, employee.getFirst_name());
			ps.setString(2, employee.getLast_name());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getDepartment());
			ps.setDouble(5, employee.getSalary());
			
			ps.executeUpdate();
			}
		finally {
			close(rs,ps,con);
			
		}
		
	}
	
	
	
	
	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub\
		Connection con= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Employee> employeesList =  new ArrayList<>();
		try {
			con = ConnectionFactory.getCon();
			ps= con.prepareStatement("select * from employees order by first_name");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				
				Employee emp = new Employee(id,first_name, last_name, email, department, salary);
				employeesList.add(emp);
				
				
				
			}
		}
		finally {
			close(rs,ps,con);
			
		}
		return employeesList;
	}




	private void close(ResultSet rs,PreparedStatement ps, Connection con)
	{
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}




	@Override
	public Employee findById(int id) throws Exception {
		// TODO Auto-generated method stub
				Connection  con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				Employee emp=null;
				
				try {
					con=ConnectionFactory.getCon();
					ps=con.prepareStatement("select * from Employees where id=?");
					ps.setInt(1, id);
					rs=ps.executeQuery();
					if(rs.next()) {
						int Id = rs.getInt("id");
						String first_name = rs.getString("first_name");
						String last_name = rs.getString("last_name");
						String email = rs.getString("email");
						String department = rs.getString("department");
						double salary = rs.getDouble("salary");
						
						emp = new Employee(id,first_name, last_name, email, department, salary);
										
						
						
					}
					}
				finally {
					close(rs,ps,con);
					
				}
				
		return  emp;
	}




	@Override
	public List<Employee> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp=null;
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from employees where first_name = ?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				
				emp = new Employee(id, firstName, lastName, email, department, salary);
				
				employeeList.add(emp);
	
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return employeeList;
		
	}




	@Override
	public void updateSalary(int id, double salary) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("update employees set salary = ? where id = ?");
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			
			ps.executeUpdate();		
			
		}
		finally {
			close(rs, ps, con);
		}
	}




	@Override
	public void deleteEmployee(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("delete from employees where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();		
			
		}
		finally {
			close(rs, ps, con);
		}
		
	}




	@Override
	public void updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update employees set  first_name= ?,last_name=?,email=?,department=?,salary=? where id = ?");
			
			ps.setString(1, employee.getFirst_name());
			ps.setString(2, employee.getLast_name());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getDepartment());
			ps.setDouble(5, employee.getSalary());
			ps.setInt(6, employee.getId());
			result=ps.executeUpdate();
			if(result==0) {
				System.out.println("id not found");
				
			}
			else {
				System.out.println("Employee data Updated\n");
			}
			}
		finally {
			close(rs,ps,con);
			
		}
		
	}

	}

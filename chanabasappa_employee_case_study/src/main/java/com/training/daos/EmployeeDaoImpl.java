package com.training.daos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.demo.exceptions.NameNotFoundException;
import com.training.entity.Employee;



public class EmployeeDaoImpl {

	private Connection con;
	Scanner sc = new Scanner(System.in);
	 Logger log = Logger.getRootLogger();
	
	
	public EmployeeDaoImpl(Connection con) {
		super();
		this.con = con;
	}


	public String createTable() throws SQLException {
		String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        try(Connection con = DriverManager.getConnection(url,"hr", "hr")) {
        	Statement pstmt = con.createStatement();
            pstmt.executeUpdate("CREATE TABLE employee"+
                    " (employeeId int primary key ,firstName varchar(20), lastName varchar(20),address varchar(60),"+
                    "emailAddress varchar(40), phoneNumber varchar(10), birthday DATE,weddingAnniversary DATE)");
            log.info("New table is created");
            System.out.println("New table with name EMPLOYEE created");
        }catch (SQLSyntaxErrorException e){
            log.warn("Table  already exists");
        }
        catch (SQLException e){
            System.out.println("Database problem :(");
            throw e;
        }
        return "table created";
    }

	


	public boolean add()  {

		String sql  = "insert into employee values(?,?,?,?,?,?,?,?)";
		int rowAdded=0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			
			
			System.out.println("Enter employee id");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter employee first name");
			pstmt.setString(2,sc.next());
			System.out.println("Enter employee last name");
			pstmt.setString(3,sc.next());
			System.out.println("Enter employee address");
			pstmt.setString(4,sc.next());
			System.out.println("Enter employee Email Id");
			pstmt.setString(5,sc.next());
			System.out.println("Enter employee phone number");
			pstmt.setLong(6, sc.nextLong());
			System.out.println("Enter employee date of birth in dd-MM-yyyy format");
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate bdate =LocalDate.parse(sc.next(),formater);
			pstmt.setDate(7,Date.valueOf(bdate));
			System.out.println("Enter employee wedding annniversary");
			LocalDate wdate =LocalDate.parse(sc.next(),formater);
			pstmt.setDate(8,Date.valueOf(wdate));
			
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return rowAdded == 1?true:false;
	}
	
	public List<Employee> findAllEmployeeTable() {
	String sql = "select * from employee";
	
	List<Employee> list = new ArrayList<>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("employeeId");
			   String firstName = rs.getString("firstName");
			   String lastName = rs.getString("lastName");
			   String address = rs.getString("address");
			   String emailAddress = rs.getString("emailAddress");
			   long phoneNumber = rs.getLong("phoneNumber");
			   LocalDate birthday = rs.getDate("birthday").toLocalDate();
			   LocalDate weddingAnniversary = rs.getDate("weddingAnniversary").toLocalDate();
			  
			   
			   Employee employee = new Employee(employeeId, firstName, lastName, address, emailAddress, phoneNumber, birthday, weddingAnniversary);
			    list.add(employee);
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
	}
	
	public Employee findEmployeeByName() throws NameNotFoundException {
		String sql = "select * from employee where firstname = ?";
		Employee employee = null;
		
		
		
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				System.out.println("enter first name of employee");
				pstmt.setString(1,sc.next());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int employeeId = rs.getInt("employeeId");
				   String firstName = rs.getString("firstName");
				   String lastName = rs.getString("lastName");
				   String address = rs.getString("address");
				   String emailAddress = rs.getString("emailAddress");
				   long phoneNumber = rs.getLong("phoneNumber");
				   LocalDate birthday = rs.getDate("birthday").toLocalDate();
				   LocalDate weddingAnniversary = rs.getDate("weddingAnniversary").toLocalDate();
				  
				   
				   employee = new Employee(employeeId, firstName, lastName, address, emailAddress, phoneNumber, birthday, weddingAnniversary);
				   
				}
				
				else {
					throw new NameNotFoundException("The user first name is not found in database");
				}
				
			} catch (SQLException e) {
				
	        	e.printStackTrace();
			}
			return employee;
		}
	
	
	public boolean updateEmployeeById() {
		String sql = "update employee set firstname = ?,lastname = ?,address=?,emailaddress=?,phonenumber=?,birthday=?,weddinganniversary=? where employeeid = ?";
		int rs=0;
		
		
		
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				System.out.println("enter employee id of employee to be updated");
				pstmt.setInt(8,sc.nextInt());
				System.out.println("enter updated first name of employee");
				pstmt.setString(1,sc.next());
				System.out.println("enter updated last name of employee");
				pstmt.setString(2,sc.next());
				System.out.println("enter updated address of employee");
				pstmt.setString(3,sc.next());
				System.out.println("enter updated emailaddress of employee");
				pstmt.setString(4,sc.next());
				System.out.println("enter phone number of employee to be updated");
				pstmt.setLong(5,sc.nextLong());
				System.out.println("Enter updated employee date of birth in dd-MM-yyyy format");
				DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate bdate =LocalDate.parse(sc.next(),formater);
				pstmt.setDate(6,Date.valueOf(bdate));
				System.out.println("Enter updated employee wedding annniversary");
				LocalDate wdate =LocalDate.parse(sc.next(),formater);
				pstmt.setDate(7,Date.valueOf(wdate));
				
			    rs = pstmt.executeUpdate();
			    
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rs== 1?true:false;
		}
	
	public List<Employee> findFnamePhone() {
	String sql = "select firstName, phoneNumber from employee";
	
	List<Employee> list = new ArrayList<>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("firstName");
			    long phoneNumber = rs.getLong("phoneNumber");
			  
			   Employee employee = new Employee( firstName,  phoneNumber);
			    list.add(employee);
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
	}
	
	public List<Employee> findFnamePhoneByWed() {
		String sql = "select firstName, phoneNumber from employee where to_char(weddinganniversary,'dd-mm')=?";
		
		List<Employee> list = new ArrayList<>();
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				
				
				System.out.println("Enter employee Wedding date in dd-MM format");

				String wdate=sc.next();
				
				pstmt.setString(1,wdate);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					String firstName = rs.getString("firstName");
				    long phoneNumber = rs.getLong("phoneNumber");
				  
				   Employee employee = new Employee( firstName,  phoneNumber);
				    list.add(employee);
				   
				}
				
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return list;
		}
	
	public List<Employee> findFnameEmailByBday() {
		String sql = "select firstName, emailaddress from employee where to_char(birthday,'dd-mm')=?";
		
		List<Employee> list = new ArrayList<>();
			try(PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				
				System.out.println("Enter employee Birth date in dd-MM format");

				String bdate=sc.next();
				
				pstmt.setString(1,bdate);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					String firstName = rs.getString("firstName");
					 String emailAddress = rs.getString("emailAddress");
				  
				   Employee employee = new Employee( firstName, emailAddress);
				    list.add(employee);
				   
				}
				
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return list;
		}
	
	
}

package com.training.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;

import com.training.entity.Student;
import com.training.ifaces.CrudRepository;

public class StudentDaoImpl implements CrudRepository<Student,Integer> {

	private Connection con;
	
	
	
	public StudentDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean add(Student t) {

		String sql  = "insert into student values(?,?,?,?)";
		int rowAdded=0;
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			
			pstmt.setInt(1, t.getRollNumber());
			pstmt.setString(2, t.getStudentName());
			pstmt.setDate(3,Date.valueOf(t.getDateOfBirth()));
			pstmt.setDouble(4, t.getMarkScored());
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return rowAdded == 1?true:false;
	}

	@Override
	public List<Student> findAll() {
	String sql = "select * from Student";
	
	List<Student> list = new ArrayList<>();
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rollNumber = rs.getInt("rollNumber");
			   String studentName = rs.getString("studentName");
			   LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
			   double markScored = rs.getDouble("markScored");
			   
			    Student student = new Student(rollNumber,studentName,dateOfBirth,markScored);
			    list.add(student);
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Student t) {
		
		int r=0;
		String sql ="update student set studentName='?',markScored=? where rollNumber =?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			 pstmt.setString(1, "Channu");
			pstmt.setDouble(2, 98);
			pstmt.setInt(3,t.getRollNumber());
			
			r=pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	
		return r;
	}

	@Override
	public boolean remove(Student t) {
	 String sql = "delete  from Student where rollNumber =?";
     int rowDeleted=0;
     try(PreparedStatement pstmt = con.prepareStatement(sql)) {


			pstmt.setInt(1, t.getRollNumber());
			rowDeleted = pstmt.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
     
    
		return rowDeleted == 1?true:false ;
	}

	@Override
	public Student findById(Integer e) {
		String sql = "select * from Student where rollNumber =?";
		Student obj = null;
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {


			pstmt.setInt(1, e);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int rollNumber = rs.getInt("rollNumber");
			   String studentName = rs.getString("studentName");
			   LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
			   double markScored = rs.getDouble("markScored");
			   
			    obj = new Student(rollNumber,studentName,dateOfBirth,markScored);
			}
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return obj;
	}

}

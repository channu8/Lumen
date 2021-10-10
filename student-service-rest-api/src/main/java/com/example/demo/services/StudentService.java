package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repos.StudentRepository;

@Service
public class StudentService {
    
	@Autowired
	private StudentRepository repo;
	
	public List<Student> findAll(){
		return this.repo.findAll();
	}
	
	public Student addStudent(Student entity) {
		return this.repo.save(entity);
	}
	
	public Student findById(Integer key) {
		return this.repo.findById(key).orElseThrow(()->new RuntimeException("Id not found"));
	}
	
	public List<Student> findByName(String name){
		return this.repo.findByStudentName(name);
	}
	
	public int updateMark(int rollNumber,double markToUpdate) {
		
		return this.repo.updateMark(rollNumber, markToUpdate);
	}
	
	public int remove(int rollNumber) {
		
		int rowDeleted=0;
		if(this.repo.existsById(rollNumber)) {
			this.repo.deleteById(rollNumber);
			rowDeleted = 1;
		}
		return rowDeleted;
		
	
	}
	
	
}

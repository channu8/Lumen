package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.StudentList;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringStudentServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringStudentServiceApplication.class, args);
		
		//StudentList list= ctx.getBean(StudentList.class);
		
		//List<Student> obj =list.getList();
		
         //obj.forEach(System.out::println);
         
         StudentList stud=ctx.getBean( StudentList.class);
        stud.getStudentList().forEach(System.out::println);
        
   	    System.out.println("is Singleton:="+ctx.isSingleton("studentList"));
    	System.out.println("is Prototype:="+ctx.isSingleton("studentList"));
		ctx.close();

		
		
	}
}

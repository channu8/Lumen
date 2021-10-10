package org.example.demo;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "students")
public class StudentService {
    
	@GET
	public String findAllStudents() {
		
		return "Ram,Sam,Bhim";
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response findStudentById(@PathParam("id")int id) {
		
		Student obj = new Student(101,"Ramesh",80);
		if(id==2) {
			obj = new Student(102,"Rajesh",70.20);
				
		}
		return Response.ok().entity(obj).build();
	}
	
	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addStudent(Student obj) {
		System.out.println(obj + "added");
		return Response.status(201).entity(obj).build();
	}
}

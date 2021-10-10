 package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		System.out.println(request.getClass().getName());
//		System.out.println(response.getClass().getName());
		
//		String branchName=request.getParameter("branch");
//		
//		System.out.println(branchName);
//		
//		StudentService service = new StudentService();
//		
//		Student found = service.findByBranch(branchName);
//		
//		request.setAttribute("foundStudent", found);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("students_details.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   
//The same can be done by using doPost method
//To make it work. We should give method="POST" in form		
		String branchName=request.getParameter("branch");
		
//		System.out.println(branchName);
		
		StudentService service = new StudentService();
		
		List<Student> found = service.findByBranch(branchName);
		
		request.setAttribute("foundStudent", found);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("students_details.jsp");
		dispatcher.forward(request, response);
	}

}

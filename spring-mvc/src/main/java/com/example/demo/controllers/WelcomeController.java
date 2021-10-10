package com.example.demo.controllers;


import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Student;

@Controller
public class WelcomeController {

	@Autowired
	private Student object;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlview;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public  String init(Model model) {
		
		model.addAttribute("majHeading","Malla Reddy College of Engineering");
		return "index";
		
	}
	
	@GetMapping(path="/addStudent")
	public String sendForm(Model model) {
		model.addAttribute("command",object);
		return "addStudent";
	}
	
	//1st method
//	@PostMapping(path ="/addStudent")
//	public String submitForm(Student student,Model model) {
//		//System.out.println(student);
//		model.addAttribute("added",student);
//		return "success";
//	}
	
	//Another way of doing(Second way)
//	@PostMapping(path ="/addStudent")
//	public ModelAndView submitform(Student student) {
//		
//		mdlview.addObject("added",student);
//		mdlview.setViewName("success");
//		return mdlview;
//	}
	
	//3rd way
	@PostMapping(path="/addStudent")
	public String submitForm(@Valid @ModelAttribute("command") Student student,BindingResult result) {
		
		String nextStep="success";
		
		
		
		if(result.hasErrors()) {
			nextStep= "addStudent";
		}else {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Student> requestBody = new HttpEntity<>(student, headers);
			template.postForObject("http://localhost:6060/api/v1/students",requestBody, Student.class);
		}
			return nextStep;
		
		
	}
	
	@GetMapping(path = "/getAllStudents")
	public String findAll(Model model) {

	Student[] resp =template.getForObject("http://localhost:6060/api/v1/students",
	Student[].class);

	model.addAttribute("data",resp);
	return "showall";

	}
	
	
}

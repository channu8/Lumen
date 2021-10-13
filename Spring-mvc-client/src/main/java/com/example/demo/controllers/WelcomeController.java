package com.example.demo.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.DonationCamp;
import com.example.demo.dto.Donor;


@Controller
public class WelcomeController {
	
	@Autowired
	private Donor donorobject;
	
	@Autowired
	private DonationCamp campobject;
	
	@Autowired
	private Donor address;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlview;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public  String init(Model model) {
		
		model.addAttribute("bloodBankName","Life Blood Bank");
		return "index";
		
	}
	
	@GetMapping(path="/addDonor")
	public String sendForm(Model model) {
		model.addAttribute("command",donorobject);
		return "addDonor";
	}
	
	
	@PostMapping(path="/addDonor")
	public String submitForm(@Valid @ModelAttribute("command") Donor donor,BindingResult result) {
		
		String nextStep="donorSuccess";
		
		
		if(result.hasErrors()) {
			nextStep= "addDonor";
			
		}else {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Donor> requestBody = new HttpEntity<>(donor, headers);
			template.postForObject("http://localhost:7070/donors",requestBody, Donor.class);
			
			
		}
			return nextStep;
		
		
	}
	
	@GetMapping(path = "/getAllDonors")
	public String findAllDonors(Model model) {

	Donor[] resp =template.getForObject("http://localhost:7070/donors",
	Donor[].class);

	model.addAttribute("data",resp);
	return "showAllDonors";

	}
	
	@GetMapping(path="/addCamp")
	public String sendForm1(Model model) {
		model.addAttribute("command",campobject);
		return "addCamp";
	}
	@PostMapping(path="/addCamp")
	public String submitForm1(@Valid @ModelAttribute("command") DonationCamp donationcamp,BindingResult result) {
		
		String nextStep="campSuccess";
		
		
		if(result.hasErrors()) {
			nextStep= "addCamp";
		}else {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<DonationCamp> requestBody = new HttpEntity<>(donationcamp, headers);
			template.postForObject("http://localhost:7071/bloodcamps",requestBody, DonationCamp.class);
			
			
		}
			return nextStep;
		}
	
	
	
	@GetMapping(path = "/getAllCamps")
	public String findAllCamps(Model model) {

	DonationCamp[] resp =template.getForObject("http://localhost:7071/bloodcamps",
	DonationCamp[].class);

	model.addAttribute("data",resp);
	return "showAllCamps";

	}
	
	@GetMapping(path = "/getDonorsInSixMonth")
	public String findDonorsInSixMonths(Model model) {

	Donor[] resp =template.getForObject("http://localhost:7070/donors/donorsLastSixMonths",
	Donor[].class);

	model.addAttribute("data",resp);
	return "showAllDonors";

	}
	
	@GetMapping(path="/searchByLoc")
	public String sendForm2(Model model)
	{
		
		model.addAttribute("data",donorobject);
		return "searchByLoc";
		
	}
	
	@GetMapping(path = "/getDonorByLoc")
	public String findDonorsByLoc(@RequestParam("address") String address,  Model model) {

	Donor[] resp =template.getForObject("http://localhost:7070/donors/srch/"+address,
	Donor[].class);
		
	model.addAttribute("data",resp);

	return "showAllDonors";

	}
	
	@GetMapping(path="/searchByBloodGroup")
	public String sendForm4(Model model)
	{
		
		model.addAttribute("data",donorobject);
		return "searchByBloodGroup";
		
	}
	
	@GetMapping(path = "/getDonorByBloodGroup")
	public String findDonorsByBloodGroup(@RequestParam("bloodGroup") String bloodGroup,  Model model) {

	Donor[] resp =template.getForObject("http://localhost:7070/donors/srchby/"+bloodGroup,
	Donor[].class);
		
	model.addAttribute("data",resp);

	return "showAllDonors";

	}
	
	@GetMapping(path="/deleteById")
	public String sendForm3(Model model) {
		model.addAttribute("data",donorobject);
		return "deleteById";
	}
	@RequestMapping(path = "/deleteDonorById")
	public ResponseEntity<String> deleteDonorById(@RequestParam("donorId") int id,  Model model) {


		
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);
	
	HttpEntity<Donor> requestBody = new HttpEntity<>( headers);
	ResponseEntity<String> resp = template.exchange("http://localhost:7070/donors/"+id, HttpMethod.DELETE, requestBody, String.class);
		if(resp.getBody().contains("One Record Deleted")) {
			return ResponseEntity.ok().body("One Donor Deleted");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Record Not Found");
		}

	}

	@GetMapping(path="/updateDonorById")
	public String sendForm5(Model model) {
		model.addAttribute("data",donorobject);
		return "updateDonorById";
	}
	
	@RequestMapping(path = "/getUpdatedDonorById")
	public ResponseEntity<String> updateDonorById(@RequestParam("donorId") int donorId,@RequestParam("donorName") String donorName,
			@RequestParam("mobileNumber") long mobileNumber, @RequestParam("bloodGroup") String bloodGroup,@RequestParam("address") String address,Model model) {


		
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);
	
	HttpEntity<Donor> requestBody = new HttpEntity<>( headers);
	ResponseEntity<String> resp = template.exchange("http://localhost:7070/donors/"+donorId+"/"+donorName+"/"+mobileNumber+"/"+bloodGroup+"/"+address, HttpMethod.PUT, requestBody, String.class);
		if(resp.getBody().contains("one Donor Details Updated")) {
			
			return ResponseEntity.ok().body("one Donor Details Updated");
		}
		else {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Record Not Found");
		}

	}

	


//	@PostMapping(path="/donorbyloc")
//	public String submitForm2(@Valid @ModelAttribute("location") String address, @ModelAttribute("command") Donor donor,BindingResult result) {
//		String nextStep="showDonorsByLoc";
//		
//		if(result.hasErrors()) {
//			nextStep= "srchByLoc";
//			
//		}else {
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			
//			
//			HttpEntity<Donor> requestBody = new HttpEntity<>(donor, headers);
//			template.getForEntity("http://localhost:7070/donors/srch/Bagalkot",
//	Donor[].class);
//			
//			
//		}
//			return nextStep;
//		
//	}

}

package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.services.DonationCampService;

@RestController
@RequestMapping(path="/bloodcamps")
public class DonationCampController {

	@Autowired
	private DonationCampService service;
	
	public void setService(DonationCampService service) {
		this.service=service;
	}
	
	@GetMapping
	public List<DonationCamp> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/{location}")
	public List<DonationCamp> findByLocation(@PathVariable("location") String location){
		
		return this.service.findByLocation(location);
	}
	
	@PostMapping
	public ResponseEntity<DonationCamp> add(@RequestBody DonationCamp entity){
		
		DonationCamp addedEntity = this.service.addDonationCamp(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	@PutMapping(path="/{bloodCampId}/{location}")
	public ResponseEntity<String> updateAddress(@PathVariable("bloodCampId") int bloodCampId
			,@PathVariable("location") String location){
		
		int count=this.service.updateAddress(bloodCampId, location);
		return ResponseEntity.ok().body(count +" BloodCamp address updated");
	}
	
	@DeleteMapping(path="/{bloodCampId}")
	public ResponseEntity<String> removeCamp(@PathVariable("bloodCampId") int bloodCampId){
		
		int count= this.service.remove(bloodCampId);
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message="Record Not Found";
		
		if(count==1)
		{
			status=HttpStatus.OK;
			message =" One camp removed";
		}
		
		return ResponseEntity.status(status).body(message);
	}
}

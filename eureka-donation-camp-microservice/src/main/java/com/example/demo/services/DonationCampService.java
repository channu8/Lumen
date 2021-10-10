package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.repo.DonationCampRepository;

@Service
public class DonationCampService {

	@Autowired
	private DonationCampRepository repo;
	
	public List<DonationCamp> findAll(){
		return this.repo.findAll();
	}
	
	public List<DonationCamp> findByLocation(String location){
		return this.repo.findByLocation(location);
	}
	
	public DonationCamp addDonationCamp(DonationCamp entity) {
		return this.repo.save(entity);
	}
	
	public int updateAddress(int bloodCampId,String location) {
		
		return this.repo.updateAddress(bloodCampId,location);
	}
	
	public int remove(int bloodCampId) {
		
		int rowDeleted=0;
		if(this.repo.existsById(bloodCampId)) {
			this.repo.deleteById(bloodCampId);
			rowDeleted = 1;
		}
		return rowDeleted;
		
	
	}
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.repos.DonorRepository;

@Service
public class DonorService {

	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll(){
		return this.repo.findAll();
	}
	
	public Donor addDonor(Donor entity) {
		return this.repo.save(entity);
	}
	
	public List<Donor> findByAddress(String address){
		return this.repo.findByAddress(address);
	}
	
	public int updateAddress(int donorId,String address) {
		
		return this.repo.updateAddress(donorId,address);
	}
	
	
	public int remove(int donorId) {
		
		int rowDeleted=0;
		if(this.repo.existsById(donorId)) {
			this.repo.deleteById(donorId);
			rowDeleted = 1;
		}
		return rowDeleted;
		
	
	}
}

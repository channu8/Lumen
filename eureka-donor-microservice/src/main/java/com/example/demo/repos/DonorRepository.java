package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	
	public List<Donor> findByAddress(String srchAddress ); 
	
	@Query(nativeQuery = true,value = "update donor set address =:adr where donor_id =:number")
	@Modifying
	@Transactional
	public int updateAddress(@Param("number")int donorId,@Param("adr")String address);

}

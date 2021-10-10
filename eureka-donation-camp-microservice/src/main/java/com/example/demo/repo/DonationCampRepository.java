package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {

	public List<DonationCamp> findByLocation(String location);
	
	@Query(nativeQuery = true,value = "update bloodcamp set location =:loc where bloodcampid =:number")
	@Modifying
	@Transactional
	public int updateAddress(@Param("number")int bloodCampId,@Param("loc")String location);
	
	
	
}

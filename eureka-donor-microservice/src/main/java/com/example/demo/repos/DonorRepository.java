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
	public List<Donor> findByBloodGroup(String bloodGroup);
	
	@Query(nativeQuery = true,value = "update donor set donorname =:name,mobilenumber=:mob,bloodgroup=:blood,address =:adr  where donor_id =:number")
	@Modifying
	@Transactional
	public int updateAddress(@Param("number")int donorId,@Param("name")String donorName,@Param("mob")long mobileNumber, @Param("blood")String bloodGroup,@Param("adr")String address);
	
	@Query(nativeQuery = true,value = "select * from donor where months_between(sysdate,lastdonationdate) between 0 and 6")
	public List<Donor> donorsLastSixMonths();


}

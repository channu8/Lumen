package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.example.demo.entity.*;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

	
}

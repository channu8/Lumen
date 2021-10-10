package com.example.demo;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class MemberService {
	
	HashMap<String,List<String>> details;
	
	public MemberService() {
		details = new HashMap<>();
		
		details.put("ram", Arrays.asList("java","dotnet"));
		details.put("sam", Arrays.asList("python","c++"));
		details.put("raj", Arrays.asList("C","Data structures"));
	}
	
	public List<String> findByMember(String memberName){
		return details.get(memberName);
	}

}

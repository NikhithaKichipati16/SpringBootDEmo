package com.example.demo.mapper;

import com.example.demo.dto.OfficersPojo;
import com.example.demo.entity.Officers;

public class OfficerMapper {
	public static OfficersPojo mapTOOfficerPojo(Officers officer) {
		return  new OfficersPojo(officer.getId(),officer.getName(),officer.getEmail());
		
	}
	public static Officers mapTOOfficers(OfficersPojo officerpojo) {
		return new Officers(officerpojo.getId(),officerpojo.getName(),officerpojo.getEmail());
		
	}

}

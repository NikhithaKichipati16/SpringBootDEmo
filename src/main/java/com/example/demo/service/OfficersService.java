package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OfficersPojo;

public interface OfficersService {
	OfficersPojo createOfficers(OfficersPojo officerspojo);
	OfficersPojo getById(Integer id);
	List<OfficersPojo>  getAllOfficer();
	void deleteOfficer(Integer id);
	OfficersPojo updateOfficer(Integer id,OfficersPojo officerpojo);
}

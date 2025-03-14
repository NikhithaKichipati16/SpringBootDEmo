package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OfficersPojo;
import com.example.demo.entity.Officers;
import com.example.demo.exception.ExceptionHandling;
import com.example.demo.mapper.OfficerMapper;
import com.example.demo.repository.Officers_Repository;
import com.example.demo.service.OfficersService;
@Service

public class OfficersImplemantation implements OfficersService {
	private Officers_Repository offrepository;
@Autowired
	public OfficersImplemantation(Officers_Repository offrepository) {
		super();
		this.offrepository = offrepository;
	}

	public OfficersPojo createOfficers(OfficersPojo officerpojo) {
		Officers officer=OfficerMapper.mapTOOfficers(officerpojo);
		Officers savedOfficer=offrepository.save(officer);
		return OfficerMapper.mapTOOfficerPojo(savedOfficer);
	}

	@Override
	public OfficersPojo getById(Integer id) {
	Officers officer=offrepository.findById(id).orElseThrow(()-> new ExceptionHandling("Id Not found Check once"));
		

		return OfficerMapper.mapTOOfficerPojo(officer) ;
	}
	
	public void deleteOfficer(Integer id) {
		Officers o=offrepository.findById(id).orElseThrow(()->new ExceptionHandling("Officer not found"));
		offrepository.deleteById(id);
		
	}
	public OfficersPojo updateOfficer(Integer id,OfficersPojo officerpojo) {
		Officers o=offrepository.findById(id).orElseThrow(()->new ExceptionHandling("id "+id+" not found"));
		o.setName(officerpojo.getName());
		o.setEmail(officerpojo.getEmail());
		Officers savedOff=offrepository.save(o);
		return OfficerMapper.mapTOOfficerPojo(savedOff);

	}

	@Override
	public List<OfficersPojo> getAllOfficer() {
		List<Officers> list=offrepository.findAll();
		return list.stream().map((off)->OfficerMapper.mapTOOfficerPojo(off)).toList();
		
	}

}

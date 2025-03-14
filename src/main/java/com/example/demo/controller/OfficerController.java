package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OfficersPojo;
import com.example.demo.service.OfficersService;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {
	@Autowired
	public OfficersService officerservice;
	public OfficerController(OfficersService officerservice) {
		super();
		this.officerservice = officerservice;
	}
	@PostMapping
	public ResponseEntity<OfficersPojo> createOfficer(@RequestBody OfficersPojo pojo){
		OfficersPojo savedOfficer=officerservice.createOfficers(pojo);
		return new ResponseEntity<>(savedOfficer,HttpStatus.CREATED);
	}
	@GetMapping("{id}")
	public ResponseEntity<OfficersPojo> getById(@PathVariable Integer id){
		OfficersPojo o=officerservice.getById(id);
		return ResponseEntity.ok(o);	
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<OfficersPojo>> getAllOfficers(){
		List<OfficersPojo> list=officerservice.getAllOfficer();
		return ResponseEntity.ok(list);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOfficer(@PathVariable Integer id){
		officerservice.deleteOfficer(id);
		return ResponseEntity.ok("Officer deleted Successfully");
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<OfficersPojo> updateOfficers(@PathVariable Integer id,@RequestBody OfficersPojo pojo){
		OfficersPojo update=officerservice.updateOfficer(id, pojo);
		return ResponseEntity.ok(update);
		
	}
	
	
	

}

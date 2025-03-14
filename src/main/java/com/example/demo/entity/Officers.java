package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Officer_details")
public class Officers {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mygen")
	@SequenceGenerator(name="mygen",sequenceName="myseq",allocationSize=1)
	private int id;
	 @Column(name = "USERNAME", length = 20)
	private String name;
	 @Column(name = "email_id", length = 25)
	private String email;
	
	

}

package com.luis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "man_details")
public class ManDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "penis_size")
	private int penisSize;
	
	@OneToOne(mappedBy = "details",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Man man;
	
	public ManDetails() {
		
	}
	
	public ManDetails(String email, int penisSize) {
		this.email = email;
		this.penisSize = penisSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPenisSize() {
		return penisSize;
	}

	public void setPenisSize(int penisSize) {
		this.penisSize = penisSize;
	}

	public Man getMan() {
		return man;
	}

	public void setMan(Man man) {
		this.man = man;
	}

}

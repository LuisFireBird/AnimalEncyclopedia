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
@Table(name = "woman_details")
public class WomanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "highlights")
	private String highlights;
	
	@OneToOne(mappedBy = "details",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Woman woman;
	
	public WomanDetails() {
		
	}
	
	public WomanDetails(String email, String highlights) {
		this.email = email;
		this.highlights = highlights;
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

	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	public Woman getWoman() {
		return woman;
	}

	public void setWoman(Woman woman) {
		this.woman = woman;
	}

}

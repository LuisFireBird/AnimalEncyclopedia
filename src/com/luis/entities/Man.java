package com.luis.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "man")
public class Man {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "man_name")
	private String manName;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "female_preference")
	private String femalePreference;
	
	@Column(name = "race")
	private String race;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "man_details_id")
	private ManDetails details;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "man_woman",joinColumns = @JoinColumn(name = "man_id"), inverseJoinColumns = @JoinColumn(name = "woman_id"))
	private List<Woman> women;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "man", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<ToysAndCustomes> toys;
	
	public Man() {
		
	}
	
	public Man(String manName, String nickName, String femalePreference, String race) {
		this.manName = manName;
		this.nickName = nickName;
		this.femalePreference = femalePreference;
		this.race = race;
	}

	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFemalePreference() {
		return femalePreference;
	}

	public void setFemalePreference(String femalePreference) {
		this.femalePreference = femalePreference;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ManDetails getDetails() {
		return details;
	}

	public void setDetails(ManDetails details) {
		this.details = details;
	}

	public List<Woman> getWomen() {
		return women;
	}

	public void setWomen(List<Woman> women) {
		this.women = women;
	}

	public List<ToysAndCustomes> getToys() {
		return toys;
	}

	public void setToys(List<ToysAndCustomes> toys) {
		this.toys = toys;
	}


}

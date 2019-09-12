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
@Table(name = "woman")
public class Woman {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "woman_name")
	private String womanName;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "male_preference")
	private String malePreference;
	
	@Column(name = "race")
	private String race;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "woman_details_id")
	private WomanDetails details;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "man_woman",joinColumns = @JoinColumn(name = "woman_id"), inverseJoinColumns = @JoinColumn(name = "man_id"))
	private List<Man> men;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name = "woman_id")
	private List<WomenReviews> reviews;
	
	public Woman() {
		
	}
	
	public Woman(String womanName, String nickName, String malePreference, String race) {
		this.womanName = womanName;
		this.nickName = nickName;
		this.malePreference = malePreference;
		this.race = race;
	}

	public String getWomanName() {
		return womanName;
	}

	public void setWomanName(String manName) {
		this.womanName = manName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMalePreference() {
		return malePreference;
	}

	public void setMalePreference(String malePreference) {
		this.malePreference = malePreference;
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

	public WomanDetails getDetails() {
		return details;
	}

	public void setDetails(WomanDetails details) {
		this.details = details;
	}

	public List<Man> getMen() {
		return men;
	}

	public void setMen(List<Man> men) {
		this.men = men;
	}

}

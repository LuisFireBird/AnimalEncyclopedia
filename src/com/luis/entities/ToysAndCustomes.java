package com.luis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "toys_costumes")
public class ToysAndCustomes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "item")
	private String item;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "man_id")
	private Man man;
	
	public ToysAndCustomes() {
		
	}
	
	public ToysAndCustomes(String item) {
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Man getMan() {
		return man;
	}

	public void setMan(Man man) {
		this.man = man;
	}
	
	
	
}

package com.luis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "women_reviews")
public class WomenReviews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "grade")
	private int grade;
	
	@Column(name = "comments")
	private String comments;
		
	public WomenReviews() {
		
	}
	
	public WomenReviews(int grade, String comments) {
		this.grade = grade;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

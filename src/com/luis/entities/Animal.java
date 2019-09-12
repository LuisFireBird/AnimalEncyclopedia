package com.luis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="animal")
public class Animal {
	
	public interface CreationValidationGroup {
		
	}
	
	public interface SearchValidationGroup {
		
	}
	
	public interface AnimalTypeValidationGroup {
		
	}
	
	@Id
	@Column(name="animal_tipo")
	@Size(min = 5,max = 15,message = "animal name size must be between 5 and 15 characters", groups = {CreationValidationGroup.class, AnimalTypeValidationGroup.class})
	@NotBlank(groups = {CreationValidationGroup.class, AnimalTypeValidationGroup.class})
	private String animalType;
	
	@Column(name="animal_color")
	@Size(min = 5,max = 15,message = "animal color size must be between 5 and 15 characters", groups = {CreationValidationGroup.class})
	@NotBlank(groups = {CreationValidationGroup.class})
	private String animalColor;
	
	@Column(name="animal_caracter")
	@Size(min = 5,max = 15,message = "animal charater size must be between 5 and 15 characters", groups = {CreationValidationGroup.class})
	@NotBlank(groups = {CreationValidationGroup.class})
	private String animalCharacter;

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalColor() {
		return animalColor;
	}

	public void setAnimalColor(String animalColor) {
		this.animalColor = animalColor;
	}

	public String getAnimalCharacter() {
		return animalCharacter;
	}

	public void setAnimalCharacter(String animalCharacter) {
		this.animalCharacter = animalCharacter;
	}

	
}

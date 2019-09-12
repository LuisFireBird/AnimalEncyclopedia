package com.luis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.luis.dao.AnimalDAO;
import com.luis.entities.Animal;
import com.luis.entities.Animal.AnimalTypeValidationGroup;
import com.luis.entities.Animal.CreationValidationGroup;
import com.luis.entities.Animal.SearchValidationGroup;

@Controller
public class AnimalController {
	
	@Autowired
	AnimalDAO dao;
	
	@RequestMapping("/CreateAnimalForm")
	public String createAnimalForm(Model model) {
		model.addAttribute("animal", new Animal());
		return "animalform";
	}
	
	@RequestMapping(value="/CreateAnimalResult", method=RequestMethod.POST)
	public String createAnimalResult(Model model, @Validated(CreationValidationGroup.class) Animal animal, BindingResult result) {
		
		if(result.hasErrors()){
			return "animalform";
		}
		
		dao.createAnimal(animal);
		return "animalcreated";
	}
	
	@RequestMapping("/ViewAllAnimals")
	public ModelAndView viewAllAnimals(@RequestParam(value = "animalDeletion", required = false) String animalDeletion, 
			@RequestParam(value = "animalTypeUpdate", required = false) String animalTypeUpdate,
			@RequestParam(value = "duplicatedError", required = false) String duplicatedError) {
		ModelAndView mav = new ModelAndView("viewallanimals");
		Map<String,Object> map = mav.getModel();
		map.put("allanimals", dao.viewAllAnimals());
		map.put("animalDeletion", animalDeletion);
		map.put("animalTypeUpdate", animalTypeUpdate);
		map.put("duplicatedError", duplicatedError);
		return mav;
	}
	
	@RequestMapping(value="/AnimalSearch")
	public String searchAnimals(Model model) {
		model.addAttribute("animal", new Animal());
		return "animalsearchform";	
	}
	
	@RequestMapping(value="/SearchAnimalResult",method = RequestMethod.POST)
	public String searchAnimalResult(Model model, @Validated(SearchValidationGroup.class) Animal animal, BindingResult result){
		if(result.hasErrors()) {
			return "animalsearchform";
		}
		model.addAttribute("animalsearchresult", dao.searchAnimalResult(animal));
		return "animalsearchresult";
	}
	
	@GetMapping("/deleteAnimalByName")
	public RedirectView deleteAnimalByName(@RequestParam("animalName") String animalName, RedirectAttributes attributes) {
		RedirectView redirect = new RedirectView();
		redirect.setContextRelative(true);
		redirect.setUrl("/ViewAllAnimals");
		attributes.addAttribute("animalDeletion",dao.deleteAnimalByName(animalName));
		dao.deleteAnimalByName(animalName);
		return redirect;
	}
	
	@GetMapping("/updateAnimalTypeForm")
	public String updateAnimalTypeForm(Model model, @RequestParam("animalType") String animalType) {
		model.addAttribute("oldAnimalType",animalType);
		model.addAttribute("animal",new Animal());
		return "animalTypeForm";
	}
	
	@GetMapping("/updateAnimalType")
	public RedirectView updateAnimalType(RedirectAttributes attributes, @Validated(AnimalTypeValidationGroup.class) Animal animal) {
		RedirectView redirect = new RedirectView("/ViewAllAnimals");
		redirect.setContextRelative(true);
		if(dao.validateExistingAnimalType(animal.getAnimalType())) {
			attributes.addAttribute("duplicatedError","the animal type chosen already exists");
		} else {
			attributes.addAttribute("animalTypeUpdate",dao.updateAnimalType(animal.getAnimalType(), animal.getAnimalColor()));
		}
		return redirect;
	}

}

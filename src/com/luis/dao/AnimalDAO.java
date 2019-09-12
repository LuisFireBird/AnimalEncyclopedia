package com.luis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luis.entities.Animal;

@Repository
public class AnimalDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void createAnimal(Animal animal) {
		Session session = getSession();
		session.saveOrUpdate(animal);
	}

	/*
	@Transactional
	public List<Animal> viewAllAnimals() {
		Session session  = sessionFactory.getCurrentSession();
		Query<Animal> query = session.createQuery("from Animal", Animal.class);
		return query.getResultList();
	}
	*/
	
	@Transactional
	public List<Animal> viewAllAnimals(){
		Session session = getSession();
		EntityManagerFactory emf = session.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);
		Root<Animal> root = cq.from(Animal.class);
		CriteriaQuery<Animal> cq2 = cq.select(root);
		TypedQuery<Animal> tq = em.createQuery(cq2);
		return tq.getResultList();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public List<Animal> searchAnimalResult(Animal animal){
		String animalType = null;
		String animalColor = null;
		String animalCharacter = null;
		String typeQuery = null;
		String colorQuery = null;
		String characterQuery = null;
		
		if(animal!=null) {
			animalType = animal.getAnimalType();
			animalColor = animal.getAnimalColor();
			animalCharacter = animal.getAnimalCharacter();
			typeQuery = " animalType like :animalType ";
			colorQuery = " animalColor like :animalColor ";
			characterQuery = " animalCharacter like :animalCharacter ";
		}
		
		String completeQuery = "from Animal where "+(typeQuery==null?"":typeQuery)+
				(colorQuery==null?"":(typeQuery==null?colorQuery:" and "+colorQuery))+
				(characterQuery==null?"":(typeQuery==null && colorQuery==null?characterQuery:" and "+characterQuery));
		
		Session session = getSession();
		Query<Animal> query = session.createQuery(completeQuery, Animal.class);
		if(animalType!=null) {
			query.setParameter("animalType", "%" + animalType + "%");
		}
		if(animalColor!=null) {
			query.setParameter("animalColor", "%" + animalColor + "%");
		}
		if(animalCharacter!=null) {
			query.setParameter("animalCharacter", "%" + animalCharacter + "%");
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public String deleteAnimalByName(String animalName) {
		String result;
		Session session = getSession();
		Query query = session.createQuery("delete from Animal where animalType = :animalNameParam");
		query.setParameter("animalNameParam", animalName);
		if(query.executeUpdate()>0) {
			result = "The animal was deleted";
		}else {
			result = "The animal was not deleted";
		}
		return result;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public String updateAnimalType(String newAnimalType, String oldAnimalType) {
		String result;
		Session session = getSession();
		Query query = session.createQuery("update Animal set animalType = : newAnimalTypeParam where animalType = : oldAnimalTypeParam");
		query.setParameter("newAnimalTypeParam", newAnimalType);
		query.setParameter("oldAnimalTypeParam", oldAnimalType);
		if(query.executeUpdate()>0) {
			result = "The animal type was updated";
		} else {
			result = "The animal type was not updated";
		}
		return result;
	}
	
	@Transactional
	public boolean validateExistingAnimalType(String animalType) {
		Session session = getSession();
		Query<Animal> query = session.createQuery("from Animal where animalType = : animalTypeParam",Animal.class);
		query.setParameter("animalTypeParam",animalType);
		Animal animal = query.getSingleResult();
		return animal==null?false:true;
	}
	
	
	
	
}

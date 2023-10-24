package com.sistemi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional  //automaticamente si espande su ogni metodo
public class StudentRepository implements StudentRepositoryI {
	
	/* Interfaccia per la comunicazione con il PersProv */
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void insertStudent(Student student) {
		/*.persist chiede per insert in database ma necessita
		 * un'apertura della connes (tramite @Transactional)*/
		em.persist(student);  //Entity Constructor senza PK
	}
	
	@Override
	public void updateStudent(Student student) {
		em.merge(student);  //Entity Constructor con PK
	}
	
	@Override
	public void deleteStudent(int id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
	
	@Override
	public List<Student> readStudents() {
		return em.createNamedQuery("Student.readStudents", Student.class).getResultList();
	}
	
	@Override
	public List<Student> readStudentByLastName(String lastName) {
		return em.createNamedQuery("Student.readStudentByLastName", Student.class)
				.setParameter("lastName", lastName)
				.getResultList();
	}
}

package com.anshul.cruddemo.dao;

import com.anshul.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        System.out.println("Creating entity manager");
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return rowsDeleted;
    }

    public List<Student> findAll(){
        //Create query to get all students
        TypedQuery<Student> query = entityManager.createQuery("From Student", Student.class);
        System.out.println(query);
        //Return resultSetList
        return query.getResultList();
    }

    public Student findByLastName(String lastName){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        query.setParameter("theData", lastName);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }
}

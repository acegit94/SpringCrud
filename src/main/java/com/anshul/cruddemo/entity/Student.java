package com.anshul.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //define fields
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //define constructors
    public Student(){

    }

    public Student(String first_name, String last_name, String email){
        firstName = first_name;
        lastName = last_name;
        this.email = email;
    }

    //define getters/setters
    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //define toString

    public String toString(){
        return  String.format("First Name: %s Last Name: %s Email: %s", firstName, lastName, email );
    }

}

package com.javapractice.demo.dao;

import java.util.UUID;

import com.javapractice.demo.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, UUID> {
    
}
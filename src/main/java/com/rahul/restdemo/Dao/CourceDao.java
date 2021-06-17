package com.rahul.restdemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.restdemo.entities.Courses;

public interface CourceDao extends JpaRepository<Courses, Long> {

	
}

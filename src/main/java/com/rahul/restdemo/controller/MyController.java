package com.rahul.restdemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.restdemo.entities.Courses;
import com.rahul.restdemo.services.CourseServices;

@RestController
public class MyController {
	
	@Autowired
	private CourseServices service;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to this Rest API";
	}
	@GetMapping(value="/courses")
	@ResponseBody
	public List<Courses> getCourses(){
		
		return this.service.getCourses();
	}
	
	@GetMapping("/courses/{coursesId}")
	public Courses getCourses(@PathVariable String coursesId){
		return this.service.getCourses(Long.parseLong(coursesId));
		
		
	}
	
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses course){
		
		return this.service.addCourses(course);
	}
	
	@PutMapping(value={"/courses", "/courses/{coursesId}"})
	public Courses updateCourses(@RequestBody Courses course,@PathVariable(required = false) String coursesId){
		if(coursesId !=null)
		{	
			System.out.println("with null id  this part = "+coursesId );
		return this.service.updateCourses(course, Long.parseLong(coursesId));
		}else
		{  System.out.println("enter this part");
			return this.service.updateCourses(course);
		}
		
	}
	
	@DeleteMapping("/courses/{coursesId}")
	public ResponseEntity<HttpStatus>  deleteCourses(@PathVariable String coursesId) {
		try {
			this.service.deleteById(Long.parseLong(coursesId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
}

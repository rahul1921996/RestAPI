package com.rahul.restdemo.services;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.rahul.restdemo.entities.Courses;

public interface CourseServices {
	public List<Courses> getCourses();

	public Courses getCourses(long coursesId);

	public Courses addCourses(Courses course);

	public Courses updateCourses(Courses course, long id);

	public void  deleteById(long id) throws InvalidAttributesException;

	public Courses updateCourses(Courses course);
}

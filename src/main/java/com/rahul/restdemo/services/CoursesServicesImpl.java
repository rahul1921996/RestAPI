package com.rahul.restdemo.services;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.restdemo.Dao.CourceDao;
import com.rahul.restdemo.entities.Courses;

@Service
public class CoursesServicesImpl implements CourseServices {
	//List<Courses> list;
	@Autowired
	 private CourceDao courcdao;
	
	public CoursesServicesImpl() {
		super();
//		list=new ArrayList<Courses>();
//		list.add(new Courses(12, "Java", "this contains the basics of java"));
//		list.add(new Courses(13, "Scala", "this contains the basics of Scala"));
//		list.add(new Courses(14, "C++", "this contains the basics of C++"));
//		list.add(new Courses(15, "C", "this contains the basics of C"));
//		list.add(new Courses(16, "Python", "this contains the basics of Python"));
	}


	@Override
	public List<Courses> getCourses() {
		
		return courcdao.findAll();
	}


	@Override
	public Courses getCourses(long coursesId) {
		Courses c=null;
//		
//		for (Courses courses : list) {
//			if(courses.getId()==coursesId)
//			{
//				c=courses;
//				break;
//			}
//		}
		
		return courcdao.getOne(coursesId);
	}


	@Override
	public Courses addCourses(Courses course) {
		//list.add(course);
		courcdao.save(course);
		return course;
	}


	@Override
	public Courses updateCourses(Courses course, long id) {
		
//		Courses c=null;
//		for (Courses courses : list) {
//			if(courses.getId()==id)
//			{
//				c=courses;
//				break;
//			}
//			
//			
//		}
//		
//		c.setTitle(course.getTitle());
//		c.setDescription(course.getDescription());
		courcdao.save(course);
		return course;
		
	}


	@Override
	public void deleteById(long id) throws InvalidAttributesException   {
//		Courses c=null;
//		for (Courses courses : list) {
//			if(courses.getId()==id)
//			{
//				c=courses;
//				break;
//			}
//		}
//		System.out.println("this is value of = "+c);
//		if(c!=null)
//		list.remove(c);
//		else
//			throw new InvalidAttributesException();
		
		Courses entity=courcdao.getOne(id);
		System.out.println("value of entity is = "+ entity);
		courcdao.delete(entity);
		
	}


	@Override
	public Courses updateCourses(Courses course) {
//		for (Courses courses : list) {
//			if(courses.getId()==course.getId())
//			{
//				courses.setTitle(course.getTitle());
//				courses.setDescription(course.getDescription());
//				
//			}
//		}
		return courcdao.save(course);
	}

}

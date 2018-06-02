package com.javainuse.springbootquickstart.courseapidata.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;


	public List<Course> getAllCourses(String topicId) {	
		List<Course> courses = new ArrayList<>();
		courseRepository.findAllByTopicId(topicId)
		.forEach(courses::add);	
		return courses;
	}

	
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);

	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(String id, Course course) {	
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

	}

}
package com.sarthak.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define end point for "/students" -return student list

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Rossi", "Mario"));
		theStudents.add(new Student("Marry", "Smith"));

		return theStudents;
	}

}

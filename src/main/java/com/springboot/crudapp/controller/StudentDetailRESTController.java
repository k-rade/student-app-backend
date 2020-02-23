package com.springboot.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapp.entity.StudentDetail;
import com.springboot.crudapp.service.StudentDetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentDetailRESTController {

	private StudentDetailService studentDetailService;

	@Autowired
	public StudentDetailRESTController(StudentDetailService theStudentDetailService) {
		studentDetailService = theStudentDetailService;
	}

	@GetMapping("/details")
	public List<StudentDetail> findAll() {
		return studentDetailService.findAll();
	}

	@GetMapping("/details/{studentDetailID}")
	public StudentDetail findById(@PathVariable int studentDetailID) {

		StudentDetail studentDetail = studentDetailService.findById(studentDetailID);

		if (studentDetail == null) {
			throw new RuntimeException("StudentDetail not found!");
		}

		return studentDetail;
	}
}

package com.springboot.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapp.entity.SeminarTask;
import com.springboot.crudapp.entity.Student;
import com.springboot.crudapp.entity.StudentDetail;
import com.springboot.crudapp.service.StudentDetailService;
import com.springboot.crudapp.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRESTController {

	private StudentService studentService;

	@Autowired
	public StudentRESTController(StudentService theStudentService) {
		studentService = theStudentService;

	}

	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}

	@GetMapping("/students/{studentID}")
	public Student findById(@PathVariable int studentID) {
		Student student = studentService.findById(studentID);

		return student;
	}

	@GetMapping("/students/{studentID}/details")
	public StudentDetail findDetails(@PathVariable int studentID) {
		Student student = studentService.findById(studentID);

		return student.getStudentDetail();
	}

	@GetMapping("/students/{studentId}/seminar-tasks")
	public List<SeminarTask> showAllSeminarTasksOfStudent(@PathVariable int studentId, SeminarTask seminarTask) {

		Student student = studentService.findById(studentId);

		return student.getSeminarTasks();

	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);

		studentService.save(student);

		return student;
	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.save(student);

		return student;
	}

	@DeleteMapping("/students/{StudentID}")
	public void deleteStudent(@PathVariable int StudentID) {
		Student student = studentService.findById(StudentID);

		if (student == null) {
			throw new RuntimeException("Student not found!");
		}

		studentService.delete(StudentID);
	}
}

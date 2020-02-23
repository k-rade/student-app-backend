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

import com.springboot.crudapp.entity.Student;
import com.springboot.crudapp.entity.Subject;
import com.springboot.crudapp.service.StudentService;
import com.springboot.crudapp.service.SubjectService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectRESTController {

	private SubjectService subjectService;
	private StudentService studentService;

	@Autowired
	public SubjectRESTController(SubjectService theSubjectService, StudentService theStudentService) {
		subjectService = theSubjectService;
		studentService = theStudentService;
	}

	@GetMapping("/subjects")
	public List<Subject> findAll() {
		return subjectService.findAll();
	}

	@GetMapping("/subjects/{subjectId}")
	public Subject findById(@PathVariable int subjectId) {

		Subject subject = subjectService.findById(subjectId);

		return subject;
	}

	@PostMapping("/subjects")
	public Subject addNewSubject(@RequestBody Subject subject) {

		subject.setId(0);

		subjectService.save(subject);

		return subject;
	}

	@PostMapping("/subjects/{studentId}")
	public Subject addSubjectToStudents(@RequestBody Subject subject, @PathVariable int studentId) {

		Student student = studentService.findById(studentId);

		student.addSubject(subject);

		subject.setId(0);

		subjectService.save(subject);

		return subject;
	}

	// get list of students assigned to certain subject
	@GetMapping("/subjects/{subjectid}/students")
	public List<Student> getAllStudentsWithSubject(@PathVariable int subjectid) {

		Subject subject = subjectService.findById(subjectid);

		List<Student> students = subject.getStudents();

		return students;
	}

	// adding student X also to subject Y
	// PUT /subjects/X/students/Y
	@PutMapping("/subjects/{subjectid}/students/{studentid}")
	public void addStudentToSubject(@PathVariable int subjectid, @PathVariable int studentid) {

		Student student = studentService.findById(studentid);

		Subject subject = subjectService.findById(subjectid);

		subject.addStudent(student);

		subjectService.save(subject);

	}

	@PutMapping("/subjects")
	public Subject updateSubject(@RequestBody Subject subject) {

		subjectService.save(subject);

		return subject;
	}

	@PutMapping("/subjects/{studentID}")
	public Subject saveSubjectToStudent(@PathVariable int studentID, @RequestBody Subject subject) {

		Student student = studentService.findById(studentID);

		student.addSubject(subject);

		subjectService.save(subject);

		return subject;
	}

	@DeleteMapping("/subjects/{subjectId}")
	public void deleteSubject(@PathVariable int subjectId) {

		subjectService.delete(subjectId);

	}

}

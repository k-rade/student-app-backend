package com.springboot.crudapp.controller;

import java.util.List;

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
import com.springboot.crudapp.service.SeminarTaskService;
import com.springboot.crudapp.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeminarTaskRESTController {

	private StudentService studentService;
	private SeminarTaskService seminarTaskService;

	public SeminarTaskRESTController(SeminarTaskService theSeminarTaskService, StudentService theStudentService) {
		seminarTaskService = theSeminarTaskService;
		studentService = theStudentService;
	}

	@GetMapping("/seminar-tasks")
	public List<SeminarTask> findAll() {
		return seminarTaskService.findAll();
	}

	@GetMapping("/seminar-tasks/{seminarTaskId}")
	public SeminarTask findById(@PathVariable int seminarTaskId) {
		return seminarTaskService.findById(seminarTaskId);
	}

	@PostMapping("/seminar-tasks")
	public SeminarTask addSeminarTask(@RequestBody SeminarTask seminarTask) {
		seminarTask.setId(0);

		seminarTaskService.save(seminarTask);

		return seminarTask;
	}

	@PostMapping("/seminar-tasks/{studentID}")
	public SeminarTask addSeminarTaskToStudent(@PathVariable int studentID, @RequestBody SeminarTask seminarTask) {

		Student student = studentService.findById(studentID);

		student.addSeminarTask(seminarTask);

		seminarTask.setId(0);

		seminarTaskService.save(seminarTask);

		return seminarTask;

	}

	@PutMapping("/seminar-tasks")
	public SeminarTask updateSeminarTask(@RequestBody SeminarTask seminarTask) {
		seminarTaskService.save(seminarTask);
		
		return seminarTask;
	}

	@PutMapping("/seminar-tasks/{studentId}")
	public SeminarTask saveSeminarTask(@PathVariable int studentId, @RequestBody SeminarTask seminarTask) {
		Student student = studentService.findById(studentId);

		student.addSeminarTask(seminarTask);

		seminarTaskService.save(seminarTask);

		return seminarTask;
	}

	@DeleteMapping("/seminar-tasks/{seminarTaskId}")
	public void deleteSeminarTask(@PathVariable int seminarTaskId) {

		seminarTaskService.delete(seminarTaskId);

	}
}

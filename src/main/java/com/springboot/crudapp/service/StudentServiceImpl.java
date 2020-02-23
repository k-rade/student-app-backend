package com.springboot.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudapp.entity.Student;
import com.springboot.crudapp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);

		Student theStudent = null;

		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			throw new RuntimeException("Student not found with id : " + theId);
		}

		return theStudent;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
	}

}

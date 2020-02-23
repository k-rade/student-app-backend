package com.springboot.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.crudapp.entity.StudentDetail;
import com.springboot.crudapp.repository.StudentDetailRepository;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

	private StudentDetailRepository studentDetailRepository;

	public StudentDetailServiceImpl(StudentDetailRepository theStudentDetailRepository) {
		studentDetailRepository = theStudentDetailRepository;
	}

	@Override
	public List<StudentDetail> findAll() {
		return studentDetailRepository.findAll();
	}

	@Override
	public StudentDetail findById(int theId) {
		Optional<StudentDetail> result = studentDetailRepository.findById(theId);
		
		StudentDetail studentDetail = null;
		
		if(result.isPresent()) {
			studentDetail = result.get();
		}else {
			throw new RuntimeException("StudentDetail was not found!");
		}
		return studentDetail;
	}

	@Override
	public void save(StudentDetail studentDetail) {
		studentDetailRepository.save(studentDetail);
	
	}

}

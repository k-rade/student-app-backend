package com.springboot.crudapp.service;

import java.util.List;

import com.springboot.crudapp.entity.StudentDetail;

public interface StudentDetailService {
	
	public List<StudentDetail> findAll();
	
	public StudentDetail findById(int theId);
	
	public void save(StudentDetail studentDetail);

}

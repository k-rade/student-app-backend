package com.springboot.crudapp.service;

import java.util.List;

import com.springboot.crudapp.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student student);

	public void delete(int id);
}

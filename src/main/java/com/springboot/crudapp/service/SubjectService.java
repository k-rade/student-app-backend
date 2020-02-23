package com.springboot.crudapp.service;

import java.util.List;

import com.springboot.crudapp.entity.Subject;

public interface SubjectService {

	public List<Subject> findAll();

	public Subject findById(int theId);

	public void save(Subject subject);

	public void delete(int theId);

}

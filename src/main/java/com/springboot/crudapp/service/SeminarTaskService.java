package com.springboot.crudapp.service;

import java.util.List;

import com.springboot.crudapp.entity.SeminarTask;


public interface SeminarTaskService {
	
	public List<SeminarTask> findAll();
	
	public SeminarTask findById(int theId);
	
	public void save(SeminarTask seminarTask);
	
	public void delete(int theId);
}

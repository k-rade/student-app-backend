package com.springboot.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudapp.entity.SeminarTask;
import com.springboot.crudapp.repository.SeminarTaskRepository;

@Service
public class SeminarTaskServiceImpl implements SeminarTaskService {

	private SeminarTaskRepository seminarTaskRepository;

	@Autowired
	public SeminarTaskServiceImpl(SeminarTaskRepository theSeminarTaskRepository) {
		seminarTaskRepository = theSeminarTaskRepository;
	}

	@Override
	public List<SeminarTask> findAll() {
		return seminarTaskRepository.findAll();
	}

	@Override
	public SeminarTask findById(int theId) {
		Optional<SeminarTask> result = seminarTaskRepository.findById(theId);

		SeminarTask seminarTask = null;

		if (result.isPresent()) {
			seminarTask = result.get();
		}
		return seminarTask;
	}

	@Override
	public void save(SeminarTask seminarTask) {
		seminarTaskRepository.save(seminarTask);

	}

	@Override
	public void delete(int theId) {
		seminarTaskRepository.deleteById(theId);
	}

}

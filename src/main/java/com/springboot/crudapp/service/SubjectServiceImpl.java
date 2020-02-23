package com.springboot.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.crudapp.entity.Subject;
import com.springboot.crudapp.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	SubjectRepository subjectRepository;

	public SubjectServiceImpl(SubjectRepository theSubjectRepository) {
		subjectRepository = theSubjectRepository;
	}

	@Override
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject findById(int theId) {
		Optional<Subject> result = subjectRepository.findById(theId);
		Subject subject = null;
		if (result.isPresent()) {
			subject = result.get();
		}
		return subject;
	}

	@Override
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	@Override
	public void delete(int theId) {
		subjectRepository.deleteById(theId);
	}

}

package com.springboot.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudapp.entity.SeminarTask;

@Repository
public interface SeminarTaskRepository extends JpaRepository<SeminarTask, Integer> {

}

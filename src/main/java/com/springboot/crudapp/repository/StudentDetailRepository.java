package com.springboot.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudapp.entity.StudentDetail;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {

}

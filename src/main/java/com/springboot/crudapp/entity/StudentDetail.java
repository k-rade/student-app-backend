package com.springboot.crudapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "jmbg")
	private long jmbg;

	@Column(name = "index_number")
	private String indexNumber;

	// generate constructors
	public StudentDetail() {

	}

	public StudentDetail(long jmbg, String indexNumber) {
		this.jmbg = jmbg;
		this.indexNumber = indexNumber;
	}

	// generate getter / setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

}

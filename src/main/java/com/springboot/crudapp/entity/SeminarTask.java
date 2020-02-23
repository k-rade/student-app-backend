package com.springboot.crudapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seminar_task")
public class SeminarTask {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "deadline")
	private String deadline;

	// one student can have many seminar tasks
	// that one seminar task can only belong to one student
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE })
	private Student student;

	// define constructors
	public SeminarTask() {

	}

	public SeminarTask(String name, String description, String deadline, Student student) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.student = student;
	}

	// generate getter / setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// generate toString method
	@Override
	public String toString() {
		return "SeminarTask [id=" + id + ", name=" + name + ", description=" + description + ", deadline=" + deadline
				+ ", student=" + student + "]";
	}

}

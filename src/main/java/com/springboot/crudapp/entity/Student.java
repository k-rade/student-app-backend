package com.springboot.crudapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "subject_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@JsonIgnore
	private List<Subject> subjects;
	
	// one user has one detail section,one detail section can only belong to one
	// user
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_detail_id")
	private StudentDetail studentDetail;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "student", cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnore
	private List<SeminarTask> seminarTasks;

	// define constructors
	// no arg constructor is required by hibernate
	public Student() {

	}

	public Student(int id, String firstName, String lastName, String email, List<Subject> subjects,
			StudentDetail studentDetail, List<SeminarTask> seminarTasks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.subjects = subjects;
		this.studentDetail = studentDetail;
		this.seminarTasks = seminarTasks;
	}

	// add convenience method for adding seminar tasks to the list of tasks
	public void addSeminarTask(SeminarTask tempSeminarTask) {

		if (seminarTasks == null) {
			seminarTasks = new ArrayList<>();
		}
		seminarTasks.add(tempSeminarTask);

		tempSeminarTask.setStudent(this);
	}

	public void addSubject(Subject subject) {
		if (subjects == null) {
			subjects = new ArrayList<>();
		}
		subjects.add(subject);
	}

	// generate getter / setter methods
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public List<SeminarTask> getSeminarTasks() {
		return seminarTasks;
	}

	public void setSeminarTasks(List<SeminarTask> seminarTasks) {
		this.seminarTasks = seminarTasks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	// generate toString method
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", subjects=" + subjects + ", studentDetail=" + studentDetail + ", seminarTasks=" + seminarTasks
				+ "]";
	}

}

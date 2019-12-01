package com.javabycode.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Student implements java.io.Serializable {
	 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String  studentName;
    private String  studentAge;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student" )
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<Project> studentProjects = new HashSet<Project>();
    
    
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	public Set<Project> getStudentProjects() {
		return studentProjects;
	}
	public void setStudentProjects(Set<Project> studentProjects) {
		this.studentProjects = studentProjects;
	}

}
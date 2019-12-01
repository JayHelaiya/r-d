package com.javabycode.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project implements java.io.Serializable{
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
 
    private String title;
    private String semester;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    
    public Project() {
    	// default
	}

	public Project(String title, String semester) {
		super();
		this.title = title;
		this.semester = semester;
	}


	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}
    
}

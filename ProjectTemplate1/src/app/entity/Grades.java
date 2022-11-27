package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Grades {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // autoincrement
	@NotNull
	@Column
	private Long id;
	
	@NotNull
	@Column
	private Long studentId;
	
	@NotNull
	@Column
	private Long subjectId;
	
	@Column
	private double grade;
	
	@NotNull
	@Column
	private String letterGrade;

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grades [id=" + id + ", studentId=" + studentId + ", subjectId=" + subjectId + ", grade=" + grade
				+ ", letterGrade=" + letterGrade + "]";
	}
	
	
}

package app.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class GradesDto {
	@NotNull
	@Column
	private Long student_id;
	
	@NotNull
	@Column
	private Long subject_id;

	@NotNull
	@Column
	private String title;
	
	@NotNull
	@Column
	private Long grade;
	
	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public Long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grades [student_id=" + student_id + ", subject_id=" + subject_id + ", title=" + title + ", grade="
				+ grade + "]";
	}
}
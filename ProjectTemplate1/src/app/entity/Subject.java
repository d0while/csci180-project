package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // autoincrement
	@NotNull
	@Column
	private Long id;
	
	@NotNull
	@Column
	private String title;
	
	@Column
	private String schedule;
	
	@NotNull
	@Column
	private Long teacher_id;
	
	@NotNull
	@Column
	private int units;
	
	@NotNull
	@Column(name = "student_id", nullable = false)
	private Long studentid;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSchedule() {
		return schedule;
	}



	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}



	public Long getTeacher_id() {
		return teacher_id;
	}



	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}



	public int getUnits() {
		return units;
	}



	public void setUnits(int units) {
		this.units = units;
	}



	public Long getStudent_id() {
		return studentid;
	}



	public void setStudent_id(Long student_id) {
		this.studentid = student_id;
	}



	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", schedule=" + schedule + ", teacher_id=" + teacher_id
				+ ", units=" + units + ", student_id=" + studentid + "]";
	}




}

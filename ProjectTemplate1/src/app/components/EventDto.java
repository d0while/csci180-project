package app.components;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class EventDto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // autoincrement
	@NotNull
	@Column
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private LocalDateTime date;
	
	@Column
	private String location;
	
	@NotNull
	@Column
	private Long student_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", location="
				+ location + ", student_id=" + student_id + "]";
	}
}

	
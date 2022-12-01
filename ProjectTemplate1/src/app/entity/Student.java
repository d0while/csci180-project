package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // autoincrement
	@NotNull
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private Long imageId;

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageid) {
		this.imageId = imageid;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}

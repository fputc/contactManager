package com.alen.contactmanager.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="contact")
public class Contact implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Date birthDate;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="contact_id")
	private List<ContactNumber> numbers;
	
	public Contact() {
		setFirstName("");
		setLastName("");
		setBirthDate(null);
	}
	
	public Contact (String firstName, String lastName, Date birthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<ContactNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<ContactNumber> numbers) {
		this.numbers = numbers;
	}
	
}

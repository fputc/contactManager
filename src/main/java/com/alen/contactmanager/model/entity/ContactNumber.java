package com.alen.contactmanager.model.entity;

import javax.persistence.*;

@Entity
public class ContactNumber {

	@Id
	@GeneratedValue
	private Long id;
	
	private String telephoneNumber;
	
	@ManyToOne
	private Contact contact; 
	
	@Enumerated(EnumType.STRING)
	private NumberType type;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NumberType getType() {
		return type;
	}

	public void setType(NumberType type) {
		this.type = type;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}

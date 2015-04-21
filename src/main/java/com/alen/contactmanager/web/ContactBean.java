package com.alen.contactmanager.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alen.contactmanager.model.dao.ContactDao;
import com.alen.contactmanager.model.entity.Contact;
import com.alen.contactmanager.model.entity.ContactNumber;
import com.alen.contactmanager.model.entity.NumberType;

@ManagedBean
@ViewScoped
public class ContactBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ContactDao contactDao = new ContactDao();
	
	private Contact contact = new Contact();
	private List<Contact> contactList = new ArrayList<Contact>();
	private String searchString = "";
	
	private ContactNumber number = new ContactNumber();
	
	public NumberType[] getNumberTypes() {
		return NumberType.values();
	}
	
	public void loadContactList() {
		if (getSearchString() == "") {
			this.setContactList(contactDao.getAll());
		}
		else {
			this.contactList = contactDao.findByName(getSearchString());
		}
	}
	
	public String saveNumber() {
		contact.getNumbers().add(number);
		contactDao.save(contact);
		return "update?faces-redirect=true&amp;includeViewParams=true";
	}

	public String saveContact() {
		contactDao.save(contact);
		return "/view/contact/update?faces-redirect=true&amp;contactId=" + contact.getId();
	}
	
	public void findContact() {
		contact = contactDao.findById(contact.getId());
	}
	
	public void deleteContact(Contact contact) {
		contactDao.delete(contact);
	}
	
	public String getFirstNumberForList(Contact contact) {
		
		if (!contact.getNumbers().isEmpty()) {
			
			ContactNumber contactNumber = contact.getNumbers().get(0);
			String response = contactNumber.getTelephoneNumber()
			+ " ("
			+ contactNumber.getType().getLabel()
			+ ")";
			
			return response;
		}
		else {
			return null;
		}
	}
	
	public String deleteNumber(ContactNumber number) {
		contact.getNumbers().remove(number);
		contactDao.save(contact);
		return "update?faces-redirect=true&amp;includeViewParams=true";
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}
	
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	public ContactNumber getNumber() {
		return number;
	}

	public void setNumber(ContactNumber number) {
		this.number = number;
	}
}

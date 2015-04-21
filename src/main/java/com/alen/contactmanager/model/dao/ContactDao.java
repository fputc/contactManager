package com.alen.contactmanager.model.dao;

import java.util.List;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Query;

import com.alen.contactmanager.model.entity.Contact;
import com.alen.contactmanager.util.HibernateUtil;

public class ContactDao implements Serializable, BaseDao<Contact>{

	private static final long serialVersionUID = 1L;

	private Session session = HibernateUtil.getSessionFactory().openSession();

	public List<Contact> getAll() {
		String hql = "FROM Contact";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public void save(Contact contact) {
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
	}

	public void delete(Contact contact) {
		session.beginTransaction();
		session.delete(contact);
		session.getTransaction().commit();
	}

	public Contact findById(Long id) {
		String hql = "FROM Contact WHERE Id = :contactId";
		Query query = session.createQuery(hql);
		query.setLong("contactId", id);
		return (Contact) query.uniqueResult();
	}

	public List<Contact> findByName(String searchString) {
		String hql = "FROM Contact "
				+ "WHERE LOWER(CONCAT(firstName, ' ', lastName, ' ', firstName)) LIKE LOWER(:searchString)";
		Query query = session.createQuery(hql);
		query.setString("searchString", "%" + searchString + "%");
		return query.list();
	}

}

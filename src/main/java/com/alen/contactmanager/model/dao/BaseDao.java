package com.alen.contactmanager.model.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public T findById(Long id);
	
	public void save(T t);
	
	public void delete(T t);
	
	public List<T> getAll();
}

package com.mobipay.customerkycweb.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface GenericDao<T, ID extends Serializable> {
	public T findById(final ID id) throws DataAccessException;
	public void save(final T domain) throws DataAccessException;
	public void delete(final T domain) throws DataAccessException;
	public Integer count() throws DataAccessException;
	public List<T> findAll() throws DataAccessException;	
}

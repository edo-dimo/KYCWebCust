package com.mobipay.customerkycweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.commons.lang.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mobipay.customerkycweb.dao.GenericDao;


//@Transactional(readOnly=true)
public class GenericDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport
	implements GenericDao<T, Serializable>{		
	private transient  final Log log = LogFactory.getLog(this.getClass());
	@SuppressWarnings("unchecked")
	public Class domainClass;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.domainClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public Integer count() throws DataAccessException {
		log.info("Count Method called for model:" + domainClass.getName());
		Session session = getSession();
		Query query = session.createQuery("select count(*) from " + domainClass.getName() + " x");
		List<T> list = query.list();	
		Integer count = NumberUtils.stringToInt(list.get(0).toString());
		return count;
	}

	public void delete(T domain) throws DataAccessException {
		log.info("Delete Method called for model:" + domainClass.getName());
		getHibernateTemplate().delete(domain);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DataAccessException {
		log.info("FindAll Method called for model:" + domainClass.getName());
		String query="from " + domainClass.getName();
		List<T> list = getHibernateTemplate().find(query);
		return list;				
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) throws DataAccessException {
		log.info("FindById Method called for model:" + domainClass.getName());
		final T domain = (T) getHibernateTemplate().get(domainClass, id);
		return domain;			
	}

//	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void save(T domain) throws DataAccessException {
		log.info("Save Method called for model:" + domainClass.getName());
		getHibernateTemplate().saveOrUpdate(domain);		
	}	
}

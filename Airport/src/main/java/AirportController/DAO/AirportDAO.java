package AirportController.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.hibernate.SessionFactory;

import AirportController.Entity.AirportEntity;

@Component
public class AirportDAO {
	
	
	SessionFactory sessionFactory ;
	public AirportDAO () {
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	public AirportDAO (SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	Session session =null;
	Query query;
	Transaction transaction ;
	public boolean saveAirportEntity( AirportEntity airport ) {

	    try {
	    	session = sessionFactory.openSession();

		    transaction = session.beginTransaction();


		    session.save(airport);
		    transaction.commit();
	    }finally {
			if(session!=null) {
				session.close();
			}
		}
	    return true;
	}
	AirportEntity entity = null;
	public AirportEntity getAirportEntityById(int id) {
		try {
			 session = sessionFactory.openSession();
			 entity = session.get(AirportEntity.class, id);
			 if(entity!=null) {
				 return entity;
			 }
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	     return entity;
	}
	
	
	public AirportEntity getAirportEntityByName(String name) {
		session = sessionFactory.openSession();
		query = session.createQuery("from AirportEntity where name='"+name+"' ");
		entity = (AirportEntity)query.uniqueResult();
		if(entity!=null) {
			 return entity;
		 }
	     return entity;
		
	}
	
	public int deleteAirportEntityById(int id) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("delete from AirportEntity where airId='"+id+"'");
		int i = query.executeUpdate();
		transaction.commit();
		return i;
	}
	public int deleteAirportEntityByName(String name) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("delete from AirportEntity where name='"+name+"'");
		int i = query.executeUpdate();
		transaction.commit();
		return i;
	}
	
	
	public List<AirportEntity> getAll() {
		session = sessionFactory.openSession();
		query = session.createQuery("from AirportEntity");
		List list = query.getResultList();
		return list;
	}

	public boolean updateAirport(AirportEntity airport) {
		 try {
		    	session = sessionFactory.openSession();

			    transaction = session.beginTransaction();


			    session.update(airport);
			    transaction.commit();
		    }finally {
				if(session!=null) {
					session.close();
				}
			}
		    return true;
	}
	
	
	
	
	
	
}

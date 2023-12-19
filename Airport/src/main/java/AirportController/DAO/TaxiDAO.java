package AirportController.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import AirportController.Entity.Taxi;

@Component
public class TaxiDAO {
	SessionFactory sessionFactory;
	Session session=null ;
	Transaction transaction=null;
	Query query=null ;
	List list=null ;
	Taxi taxi=null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public TaxiDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		
	}

	public TaxiDAO() {
		
	}
	
	
	public boolean saveTaxi(Taxi taxi) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(taxi);
			transaction.commit();
			return true;
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	
	
	public List<Taxi> searchTaxiById(int id) {
		System.out.println("searchTaxiById() invoked");
		try {
			session = sessionFactory.openSession();
			query = session.createQuery("from Taxi where airId='"+id+"'");
			list = query.getResultList();
			return list;
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
	}
	
	public Taxi getTaxiByName(String name) {
		try {
			session = sessionFactory.openSession();
			query = session.createQuery("from Taxi where dName='"+name+"'");
			taxi = (Taxi)query.uniqueResult();
			if(taxi != null) {
				return taxi;
			}else {
				return taxi;
			}
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
	}
	
	public boolean updateTaxi(Taxi taxi) {
		boolean flag = true;
		try {
			System.out.println("updateTaxi(Taxi taxi) invoked");
			session  = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(taxi);
			transaction.commit();
			return flag;
			
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

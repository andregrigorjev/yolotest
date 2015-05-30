package remont.dao;

import java.util.List;




import remont.log.MyLogger;
import remont.model.Property;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PropertyDAO {

	private Property Current_Property;
	private List<Property> PropertyList;
	private Property[] propertymassiiv;
	
	public Property findById(Integer id) {
        Current_Property = null ;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Session isConnected(): " + session.isConnected());
			session.beginTransaction();
			Query q = session.createQuery("from Property as p where p.propertyID =:id");
			q.setInteger("id", id);
			Current_Property = (Property) q.uniqueResult();
			System.out.println(Current_Property);
		} catch(Exception ex) { 
			MyLogger.Log("PropertyDAO.findById:", ex.getMessage());
			} finally {
				session.close();
			}
		return Current_Property;
	}
	
	public Property[] findAll(){
		propertymassiiv = null;
		List<Property> list = findAllinList();
		propertymassiiv = list.toArray(new Property[list.size()]);
		return propertymassiiv;
	}
	
	
	public List<Property> findAllinList() {
        PropertyList = null ;
        Session session = null ;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			PropertyList = session.createQuery("from Property as p").list();
		} catch(Exception ex) { 
			MyLogger.Log("PropertyDAO.findAll():", ex.getMessage());
			} finally {
			   session.close();
			}
		return PropertyList;
	}
	
	public void update(Property property) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    Transaction tx = null;
	    try {
	    	tx = session.beginTransaction();
	    	session.update(property);
	    	tx.commit();
	    } catch(Exception ex) { 
	    	if(tx != null) tx.rollback();
	    	MyLogger.Log("PropertyDAO.update():", ex.getMessage());
	    } 
	}
}

package com.placideh.hibernatea12;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con =new Configuration().configure().addAnnotatedClass(Laptop.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session =sf.openSession();
    	session.beginTransaction();
    	
    	Laptop l=new Laptop();
    	l.setLid(52);
    	l.setBrand("Lenovo");
    	l.setPrice(800);
    	session.save(l);
    	l.setPrice(750);
    	
    	session.remove(l); //THIS WILL REMOVE  THE OBJECT FROM THE DATABASE
    	
    	session.getTransaction().commit();
    	//THIS IS WILL NOT BE UPDATED IN THE DATABASE SINCE IT IS DETACHED
    	session.detach(l);
    	l.setPrice(600);
    	
    	session.close();
    }
}

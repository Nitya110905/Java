package com.hibernate.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sf =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
//        User u1 = new User(1,"bhb",9776875,"bukvugjbaj jqbhdsgu");
//        session.save(u1);
        
//        User u = session.get(User.class, 3);
//        System.out.println(u);

        
//        User u1 = new User(3, "python", 98654321, "xyz");
//        session.save(u1);
//        
        User u = session.get(User.class, 3);
        session.delete(u);

        
        tx.commit();
        session.close();
        sf.close();
    }
    
}

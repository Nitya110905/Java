package one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("abc");
		s1.setContact(798780980);
		
		
		Mobile m1 = new Mobile();
		m1.setId(1);
		m1.setModel("samsung");
		m1.setConfig("8gb");
		
		s1.setMobile(m1);
		m1.setStudent(s1);
		
		session.save(s1);
		session.save(m1);
		
		tx.commit();
		session.close();
		sf.close();
		
	}
}

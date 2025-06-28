package one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Student2 s = new Student2();
		s.setSid(1);
		s.setName("bijdbci");
		s.setContact(797007968);
		
		Mobile2 m1 = new Mobile2();
		m1.setMid(1);
		m1.setName("s24");
		m1.setCompany("Samsung");
		
		Mobile2 m2 = new Mobile2();
		m2.setMid(2);
		m2.setName("16-pro_max");
		m2.setCompany("Iphone");
		
		List<Mobile2> list = new ArrayList<Mobile2>();
			list.add(m1);
			list.add(m2);
			
			s.setMobile(list);
			m1.setStudent(s);
			m2.setStudent(s);
			
			session.save(s);
			session.save(m1);
			session.save(m2);
			
			tx.commit();
			session.close();
			sf.close();
		
	}
}

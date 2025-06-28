package many_to_many;

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
	
	Student1 s1 = new Student1();
	s1.setId(1);
	s1.setName("bcd");
	s1.setContact(989868687);
	
	
	Student1 s2 = new Student1();
	s2.setId(2);
	s2.setName("abc");
	s2.setContact(9898687);
	
	Student1 s3 = new Student1();
	s3.setId(3);
	s3.setName("cd");
	s3.setContact(8986868);
	
	Courses c1 = new Courses();
	c1.setCid(1);
	c1.setCname("cs");
	c1.setDuration("5 months");
	
	Courses c2 = new Courses();
	c2.setCid(2);
	c2.setCname("it");
	c2.setDuration("7 months");
	
	
	List<Student1> slist = new ArrayList<Student1>();
	slist.add(s1);
	slist.add(s2);
	slist.add(s3);
	
	List<Courses> clist = new ArrayList<Courses>();
	clist.add(c1);
	clist.add(c2);
	
	s1.setCourses(clist);
	s2.setCourses(clist);
	s3.setCourses(clist);

	c1.setStudent(slist);
	c2.setStudent(slist);

	session.save(s1);
	session.save(s2);
	session.save(s3);
	session.save(c1);
	session.save(c2);

	tx.commit();
	session.close();
	sf.close();
		
     }
}

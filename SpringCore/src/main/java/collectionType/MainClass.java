package collectionType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("CollectionType/coll.xml");
		User u = (User)con.getBean("u1");
		System.out.println(u);
	}
}

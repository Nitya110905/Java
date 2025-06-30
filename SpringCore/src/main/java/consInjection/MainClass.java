package consInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("consInjection/cons.xml");
		User u = (User)con.getBean("u1");
		System.out.println(u);
	}
}


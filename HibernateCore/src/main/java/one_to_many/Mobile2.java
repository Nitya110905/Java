package one_to_many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Mobile2 {
	@Id
	private int mid;
	private String name;
	private String Company;
	@ManyToOne
	private Student2 student;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Student2 getStudent() {
		return student;
	}
	public void setStudent(Student2 student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Mobile2 [mid=" + mid + ", name=" + name + ", Company=" + Company + ", student=" + student + "]";
	}
	
}

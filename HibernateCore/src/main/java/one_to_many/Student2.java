package one_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student2 {
	@Id
	private int sid;
	private String name;
	private long contact;
	@OneToMany(mappedBy = "student")
	private List<Mobile2> mobile;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public List<Mobile2> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile2> mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student2 [sid=" + sid + ", name=" + name + ", contact=" + contact + ", mobile=" + mobile + "]";
	}
	
	
}

package many_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;


@Entity
public class Courses {
	@Id
	private int cid;
	private String cname;
	private String duration;
	@ManyToMany
	private List<Student1> student;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<Student1> getStudent() {
		return student;
	}
	public void setStudent(List<Student1> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Courses [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", student=" + student + "]";
	}
	
}

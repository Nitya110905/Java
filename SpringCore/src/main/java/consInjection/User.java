package consInjection;

public class User {
	int id;
	String name;
	String address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String address) {
		super();
		System.out.println("set by cons");
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}

package My_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Laptop implements Serializable{
	private int id;
	private String model;
	private double price;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int id, String model, double price) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Laptop [id=" + id + ", model=" + model + ", price=" + price + "]";
	}
}
public class P020_Serialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Laptop l1 = new Laptop(1, "hp", 34540);
		FileOutputStream fos = new FileOutputStream("laptop.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(l1);
		oos.flush();
		oos.close();
		System.out.println("object stored into file");

		FileInputStream fis = new FileInputStream("laptop.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Laptop l = (Laptop) ois.readObject();
		System.out.println(l);
	}
}

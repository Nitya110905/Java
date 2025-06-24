package My_Package;

interface inter1{
	public void interface1();
		public static void interface11() {
			System.out.println("interface11");
		}
}

interface inter2 extends inter1{
	public void interface2();
		public static void interface22() {
			System.out.println("interface22");
		}
}

interface inter3 extends inter2{
	public void interface3();
		public static void interface33() {
			System.out.println("interface33");
		}
}

class Calling implements inter2{
	public void interface1() {
		System.out.println("Interface1");
	}
	public void interface3() {
		System.out.println("Interface3");
	}
//	public static void interface22() {
//		System.out.println("interface22");
//	}
	public void interface2() {
		System.out.println("Interface2");
	}
}

public class P016_Interface {
	public static void main(String[] args) {
		Calling c = new Calling();
		c.interface1();
		c.interface2();
		c.interface3();
		inter1.interface11();
		inter2.interface22();
		inter3.interface33();
	}
}

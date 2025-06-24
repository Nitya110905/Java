package My_Package;

class A{
	A(){
		System.out.println("Default cons in A");
	}
	public void classA() {
		System.out.println("Class A");
	}
}

class B extends A{
	public void classB() {
		System.out.println("Class B");
	}
}

class C extends B{
	public void classC() {
		System.out.println("Class C");
	}
}

class D extends A{
	public void classD() {
		System.out.println("Class D");
	}
}

public class P013_Inheritance {
	public static void main(String[] args) {
		B b = new B();
		b.classA();
		b.classB();
		
		C c = new C();
		c.classA();
		c.classB();
		c.classC();
		
		D d = new D();
		d.classA();
		d.classD();
	}
}

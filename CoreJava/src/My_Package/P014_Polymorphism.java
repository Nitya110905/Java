package My_Package;

class Overload{
	public int add(int a , int b) {
		return a+b;
	}
	
	public int add(int a , int b, int c) {
		return a+b+c;
	}
}

class Overriding{
	public void show() {
		System.out.println("Show is Overriding in parent");
	}
}

class Override extends Overriding{
	public void show() {
		System.out.println("show in override");
		super.show();
	}
	public void call() {
		System.out.println("Call in Child");
	}
}

public class P014_Polymorphism {
	public static void main(String[] args) {
		Overload o = new Overload();
		int res = o.add(1,20);
		System.out.println(res);
		
		int res2 = o.add(2,3,4);
		System.out.println(res2);
		
		Override o1 = new Override();
		o1.show();
		o1.call();
		
	}
}

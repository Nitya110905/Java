package My_Package;
class Employee{
	int id;
	String name;
	double salary;
	Employee(){
		System.out.println("default cons");
	}
	Employee(int id,String name,double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
		System.out.println("id : "+id+" name : "+name+ " salary : "+salary);
	}
	Employee(Employee e){
		this.id = e.id;
		this.name= e.name;
		this.salary = e.salary;
	}
	public void show() {
		System.out.println("id : "+id+" name : "+name+ " salary : "+salary);
	}
}

public class P011_Constructor {
		public static void main(String[] args) {
			Employee e1 = new Employee();
			Employee e2 = new Employee(1, "java", 3454.34);
			e2.show();
			Employee e3 = new Employee(e2);
			e3.show();
		}
}




//Is it compulsory to call a constructor of a superclass in a subclass?
//In Java, it is not mandatory to explicitly call a constructor of the superclass in the subclass. However, if you don't, the Java compiler will automatically insert a call to the no-argument constructor (super()) of the superclass at the beginning of the subclass constructor.
//
//Here are the key points to understand:
//
//Automatic Call to No-Argument Constructor: If the superclass has a no-argument (default) constructor, the compiler will insert super() at the beginning of the subclass constructor if you don't explicitly call any superclass constructor.
//
//No Default Constructor: If the superclass does not have a no-argument constructor, you must explicitly call one of the superclass's parameterized constructors using super(arguments), because the compiler cannot call a non-existent no-argument constructor.
//
//Custom Initialization: If the superclass has only parameterized constructors, you must explicitly call one of these constructors using super(arguments) in the subclass constructor to ensure proper initialization.

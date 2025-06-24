package My_Package;
class QQQ{
    public static void main(Integer[] args) {
    	System.out.println("main method in QQQ class");
    }
}
class QQQ1{
    public static void main(Integer[] args) {
    	System.out.println("main method in QQQ1 class");
    }
}

public class P002_Main_method {
         public static void main(String[] args) {
        	 System.out.println("main method");
         }
         public static void main(Integer[] args) {
        	 System.out.println("main"); 
         }
}


/*In Java, the entry point of a program is a method with the signature public static void main(String[] args).
When you run a Java application,the Java Virtual Machine (JVM) looks for this specific method to start the
execution.*/
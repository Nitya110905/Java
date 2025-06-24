package My_Package;

public class P021_Thread {
	public static void main(String[] args) {
		Thread t = new Thread();
		System.out.println(Thread.currentThread());
		t.setName("My Thread");
		System.out.println(t);
		for(int i = 1; i<=5; i++) {
			try {
				System.out.println(t+" : "+i);
				t.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

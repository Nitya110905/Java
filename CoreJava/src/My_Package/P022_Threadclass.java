package My_Package;

class ByThreadClass extends Thread {
	public void run() {
		for(int i = 1; i<=5; i++) {
			try {
				System.out.println(Thread.currentThread()+ " : "+ i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

class ByRunnable extends Object implements Runnable{
	public void run() {
		for(int i = 1; i<=5; i++) {
			try {
				System.out.println(Thread.currentThread()+ " : "+ i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
public class P022_Threadclass {
	public static void main(String[] args) {
		Thread t = new Thread();
		System.out.println(t.currentThread());
		t.setName("Mythread");
		long startTime=  System.currentTimeMillis();
		System.out.println(startTime);
		System.out.println(t);
		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println(t + " : " + i);
				
				t.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ByThreadClass t1 = new ByThreadClass();
		t1.run();
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		System.out.println("time taken to execute thread is : "+(endTime-startTime));
	}
}

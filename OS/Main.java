
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class Main {
	// 创建三个信号量
	final Semaphore S2 = new Semaphore(0); // 私用信号量S2，用以表示，初值为 0；
	final Semaphore S3 = new Semaphore(0); // 私用信号量S2，用以表示，初值为 0；
	final Semaphore mutex1 = new Semaphore(1);
	final Semaphore mutex2 = new Semaphore(1);
	final Semaphore mutex3 = new Semaphore(1);
	private static Scanner scan;
	static int n;
	static float nowTime;
	static TreeMap<String, Integer> map;
	static String travelist[];
	static String name;
	static int time;

	public static void main(String[] args) {
		Main pcsTest = new Main();
		scan = new Scanner(System.in);
		while (scan.hasNext()) {
			nowTime = 0;
			n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				name = "";
				travelist = scan.next().split(",");
				name = travelist[0];
				time = Integer.parseInt(travelist[1]) * 1000;
				new Thread(pcsTest.new Buyticket(), name).start();
				;
				new Thread(pcsTest.new Checkticket(), name).start();
				new Thread(pcsTest.new Enter(), name).start();
			}

		}
	}

	class Buyticket implements Runnable {
		public void run() {
			try {
				Thread.sleep(time);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName() + ",Buy a ticket;");
				S2.release(); // V
			}

		}
	}

	class Checkticket implements Runnable {
		public void run() {
			try {
				S2.acquire(); // P
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName() + ",Security check;");
				S3.release(); // V
			}

		}
	}

	class Enter implements Runnable {
		public void run() {
			try {
				S3.acquire(); // P
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName() + ",Enter the station;");
			}

		}
	}
}

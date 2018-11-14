
import java.util.concurrent.Semaphore;


public class ProductorConsumerSemaphore {
    private static Integer count = 0;
    //创建三个信号量
    final Semaphore notFull = new Semaphore(10);  // 私用信号量S1，用以表示可用缓冲区数，初值为n。
    final Semaphore notEmpty = new Semaphore(0);  // 私用信号量S2，用以表示产品数目，初值为 0；
    final Semaphore mutex = new Semaphore(1);
    public static void main(String[] args) {
        ProductorConsumerSemaphore pcsTest = new ProductorConsumerSemaphore();
        new Thread(pcsTest.new Producer()).start();
        new Thread(pcsTest.new Consumer()).start();
        new Thread(pcsTest.new Producer()).start();
        new Thread(pcsTest.new Consumer()).start();
        new Thread(pcsTest.new Producer()).start();
        new Thread(pcsTest.new Consumer()).start();
        new Thread(pcsTest.new Producer()).start();
        new Thread(pcsTest.new Consumer()).start();
    }
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    notFull.acquire();  //P
                    mutex.acquire();  //P
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();    //V
                    notEmpty.release();  //V
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        public void run() {
        	
            for (int i = 0; i < 10; i++) { 
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class ProductorConsumer {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";
    private static int iteratorNum = 20;
    
    public static void main(String[] args) {
    	ProductorConsumer pcTes = new ProductorConsumer();
        new Thread(pcTes.new Producer()).start();   //0
        new Thread(pcTes.new Consumer()).start();   //1
        new Thread(pcTes.new Producer()).start();   //2
        new Thread(pcTes.new Consumer()).start();   //3
        new Thread(pcTes.new Producer()).start();   //4
        new Thread(pcTes.new Consumer()).start();   //5
        new Thread(pcTes.new Producer()).start();   //6
        new Thread(pcTes.new Consumer()).start();   //7
    }
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < iteratorNum; i++) {
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < iteratorNum; i++) { 
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

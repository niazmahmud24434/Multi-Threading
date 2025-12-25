public class MultiThreading {

    static int counter = 0;
    static boolean numberTurn = true;

    static synchronized void printNumber(int n) {
        while (!numberTurn) {
            try {
                MultiThreading.class.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Number: " + n);
        counter++;
        numberTurn = false;
        MultiThreading.class.notify();
    }

    static synchronized void printSquare(int n) {
        while (numberTurn) {
            try {
                MultiThreading.class.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Square: " + (n * n));
        counter++;
        numberTurn = true;
        MultiThreading.class.notify();
    }

    static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                printNumber(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class SquareThread implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                printSquare(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        Thread t2 = new Thread(new SquareThread());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Final Counter Value: " + counter);
    }
}

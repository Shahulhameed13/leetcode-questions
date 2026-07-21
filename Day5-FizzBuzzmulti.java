import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private AtomicInteger current = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz"
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current.get() <= n) {
            synchronized (this) {
                while (current.get() <= n && 
                       (current.get() % 3 != 0 || current.get() % 5 == 0)) {
                    wait();
                }

                if (current.get() > n) {
                    notifyAll();
                    return;
                }

                printFizz.run();
                current.incrementAndGet();
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz"
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current.get() <= n) {
            synchronized (this) {
                while (current.get() <= n && 
                       (current.get() % 5 != 0 || current.get() % 3 == 0)) {
                    wait();
                }

                if (current.get() > n) {
                    notifyAll();
                    return;
                }

                printBuzz.run();
                current.incrementAndGet();
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz"
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current.get() <= n) {
            synchronized (this) {
                while (current.get() <= n && 
                       (current.get() % 3 != 0 || current.get() % 5 != 0)) {
                    wait();
                }

                if (current.get() > n) {
                    notifyAll();
                    return;
                }

                printFizzBuzz.run();
                current.incrementAndGet();
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x"
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current.get() <= n) {
            synchronized (this) {
                while (current.get() <= n && 
                       (current.get() % 3 == 0 || current.get() % 5 == 0)) {
                    wait();
                }

                if (current.get() > n) {
                    notifyAll();
                    return;
                }

                printNumber.accept(current.get());
                current.incrementAndGet();
                notifyAll();
            }
        }
    }
}

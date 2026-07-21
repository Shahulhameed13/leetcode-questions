import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int current = 1;
    private int state = 0; 
    // state: 0 -> zero's turn, 1 -> odd's turn, 2 -> even's turn

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(0)
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (state != 0) {
                    wait();
                }

                printNumber.accept(0);

                if (current % 2 == 1) {
                    state = 1; // odd
                } else {
                    state = 2; // even
                }

                notifyAll();
            }
        }
    }

    // printNumber.accept(x)
    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (state != 1 && current <= n) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printNumber.accept(current);
                current++;

                state = 0; // zero's turn
                notifyAll();
            }
        }
    }

    // printNumber.accept(x)
    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (state != 2 && current <= n) {
                    wait();
                }

                if (current > n) {
                    notifyAll();
                    return;
                }

                printNumber.accept(current);
                current++;

                state = 0; // zero's turn
                notifyAll();
            }
        }
    }
}

class Foo {
    private Semaphore sem1 = new Semaphore(0);
    private Semaphore sem2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        sem1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem1.acquire();
        printSecond.run();
        sem2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem2.acquire();
        printThird.run();
    }
}

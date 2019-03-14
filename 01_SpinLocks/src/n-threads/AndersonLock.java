public class AndersonLock implements NThreadsLock {

    private boolean locked ;

    public AndersonLock (int nb_threads) {
        locked = false;
    }

    public void lock(int i) {
        synchronized(this) {
            while (locked) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            locked = true;
        }
    }

    public void unlock(int i) {
        synchronized(this) {
            locked = false;
            notify();
        }
    }
}

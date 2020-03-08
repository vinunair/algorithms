package com.github.vinunair;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class UberSeatingProblem {
    Semaphore demsWaiting = new Semaphore(0);
    Semaphore repubsWaiting = new Semaphore(0);
    CyclicBarrier barrier = new CyclicBarrier(4);
    ReentrantLock lock = new ReentrantLock();

    int democrats;
    int republicans;
    boolean rideConfirmed = false;

    void seated() {}

    void drive() {}

    void seatDemocrat() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        democrats++;
        if(democrats >=4) {
            demsWaiting.release(4);
            democrats-=4;
            rideConfirmed = true;
        }
        if(democrats == 2 && republicans >=2) {
            demsWaiting.release(2);
            repubsWaiting.release(2);
            democrats-=2;
            republicans-=2;
            rideConfirmed = true;
        }
        else {
            demsWaiting.acquire();
            lock.unlock();
        }
        seated();
        barrier.await();
        if(rideConfirmed) {
            drive();
            lock.unlock();
        }
    }
    
}
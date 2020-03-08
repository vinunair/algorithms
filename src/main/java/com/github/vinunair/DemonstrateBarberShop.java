package com.github.vinunair;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class BarberShop {
    int waitingChairs;
    int availableChairs;
    Semaphore barberChairPermit = new Semaphore(1);
    ReentrantLock lock = new ReentrantLock();

    BarberShop(int chairs) {
        this.waitingChairs = chairs;
        this.availableChairs = this.waitingChairs;
    }

    void customerWalksIn() throws InterruptedException {
        lock.lock();
        if(availableChairs == 0) {
            lock.unlock();
            return;
        }
        if(availableChairs > 0 &&  availableChairs <= waitingChairs)
          availableChairs--;
        lock.unlock();  
        barberChairPermit.acquire();  
        barber();
        lock.lock();
        availableChairs++;
        lock.unlock();

    }

    void barber() {
        barberChairPermit.release();
    }
}
package com.github.vinunair;

import java.util.concurrent.Semaphore;

class DiningPhilospher {
    Semaphore forks [] ;
    Semaphore maxDiners; 
    
    DiningPhilospher(int num) {
        forks = new Semaphore[num];
        for(int i= 0 ; i < num; i++) 
          forks[i] = new Semaphore(1);
        maxDiners = new Semaphore(num-1);  
    }

    public void lifeCycleOfPhilospher(int id) {
        while(true) {
            
        }
    }

    public void contemplate() {

    }

    public void eat(int id) throws InterruptedException {
        maxDiners.acquire();
            forks[id].acquire();
            forks[(id+1)%5].acquire();
            System.out.println("Philosopher id "+id +" is eating");
            forks[id].release();
            forks[(id+1)%5].acquire();
        maxDiners.release();
    }
}
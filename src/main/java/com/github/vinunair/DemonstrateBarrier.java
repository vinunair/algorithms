package com.github.vinunair;

class Barrier {
    int totalThreads;
    int count = 0;
    int released ;

    public Barrier(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {
        if(count == totalThreads) {
            notifyAll();
            released = totalThreads;
        }
        else {
            count++;
            while(count < totalThreads)
              wait();
        }

        released--;
        if(released == 0)
          count = 0;
    }
}
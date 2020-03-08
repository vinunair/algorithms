package com.github.vinunair;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintFooBarAlternatively {
    private int n;
    private AtomicInteger counter = new AtomicInteger(0);

    public PrintFooBarAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
           while(true) {
               if(counter.get()%2 == 0)
                  break;
                counter.incrementAndGet();  
           }       
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(true) {
                if(counter.get()%2 != 0)
                   break;
                 counter.incrementAndGet();  
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}
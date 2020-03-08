package com.github.vinunair;

import java.util.concurrent.Semaphore;

class UniSexBathRoom {
    Semaphore maxEmp = new Semaphore(3);
    String genderUsage = "N";
    int empsInBath ;

    void useBathroom(String name) throws InterruptedException {
        System.out.println("\n" + name + " using bathroom. Current employees in bathroom = " + empsInBathroom + " " + System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println("\n" + name + " done using bathroom " + System.currentTimeMillis());
    }

    void maleUseBathroom(String name) throws InterruptedException {
        synchronized(this) {
            while(genderUsage.equals("F")) {
                this.wait();
            }
            maxEmp.acquire();
            genderUsage="M";
            empsInBath++;
        }
            useBathroom(name);
            maxEmp.release();

        synchronized(this) {
            empsInBath--;
            if(empsInBath==0)
            genderUsage="N";
            this.notifyAll();
        }
    }
    void femaleUseBathroom(String name) throws InterruptedException {
        synchronized(this) {
            while(genderUsage.equals("M")) {
                this.wait();
            }
            maxEmp.acquire();
            genderUsage="F";
            empsInBath++;
        }
          useBathroom(name);
          maxEmp.release();
        
        synchronized(this) {
            empsInBath--;
            if(empsInBath==0)
            genderUsage="N";
            this.notifyAll();
        }  
    }
}
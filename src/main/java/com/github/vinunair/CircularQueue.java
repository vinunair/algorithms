package com.github.vinunair;

public class CircularQueue {

    int size ;
    int head = 0;
    int [] queue ;
    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void insert(int val) {
        queue[head] = val;

        if(head < size-1)  {
            head++;
        } else {
            head = (head +1)%size;
        }
            
    }

    public void print() {
        for(int val : queue) 
            System.out.println(val);
    }

    public static void main(String args[]) {
        CircularQueue queue = new CircularQueue(5);
        for(int i =1; i<=10;i++)
            queue.insert(i);

         queue.print();

    }
}
package com.github.vinunair;

public class BitManipulation {

    //hour 0-23 = 5 bits
    //min 0 -60 = 6 bits
    //sec 0-60  = 6 bits
    
    
    public static void main(String args[]) {
       int timestamp = (short) (24*60*60);
       short day =  (short)65535 << 1;
       System.out.println(day);
    }

}
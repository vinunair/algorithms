package com.github.vinunair;

class Node {
    public Node() {}
    public Node next;

}

public class ReverseLinkList {
    Node dummy = new Node();
    int s = 0;

    public Node reverse(Node node) {
        if(node == null)
          return dummy; 
        Node prev = reverse(node.next);
        prev.next = node;
        return node;  
    }

    public static void main(String args[]) {
        ReverseLinkList rec = new ReverseLinkList();
        Node head = null;
        rec.reverse(head);
        System.out.println(rec.s);
    }

}
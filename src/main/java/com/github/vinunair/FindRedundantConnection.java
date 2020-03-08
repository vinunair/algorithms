package com.github.vinunair;

import java.util.Arrays;

// Disjoint Set Union
public class FindRedundantConnection {

    class Node {
        int data;
        Node parent;
        int rank;
    }

    public int[] findRedundantConnection(int[][] edges) {
        Node[] parent = new Node[edges.length+1];   
        int result[] = null;
        
        for(int i= 1 ; i <= edges.length ; i++) {
            parent[i] = new Node();
            parent[i].parent = parent[i];
            parent[i].data = i;
            parent[i].rank = 0;
        }

        for(int[] edge : edges) {
            if(!isConnected(parent[edge[0]],parent[edge[1]])) 
                union(parent[edge[0]], parent[edge[1]]);
             else {
                 result = edge;
                 break;
             }   
        }

        return result;
    }

    public Node findParent(Node node) {
        if(node!=null && node == node.parent)
            return node;
        node.parent= findParent(node.parent);    
        return node.parent;
    }
    
    public boolean isConnected(Node node1, Node node2) {
        return findParent(node1) ==findParent(node2);
    }

    public void union(Node node1, Node node2) {
        Node parentNode1 = findParent(node1);
        Node parentNode2 = findParent(node2);

        if(parentNode1!=parentNode2) {
            if(parentNode1.rank>= parentNode2.rank) {
                parentNode2.parent = parentNode1;
                parentNode1.rank++;
            }
            else if(parentNode2.rank > parentNode1.rank) {
                parentNode1.parent = parentNode2;
                parentNode2.rank++;
            }
            
        }
    }

    public static void main(String args[]) {
        FindRedundantConnection connection = new FindRedundantConnection();
        int edges[][] = new int[][] { {1,2},{1,3},{2,3}};
        int[] result = connection.findRedundantConnection(edges);
        System.out.println(Arrays.asList(result[0],result[1]));
    }
}
package com.github.vinunair;

public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4*N*N);
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ;c++) {
                int root = 4 *(r* N +c);
                if(grid[r].charAt(c)!='\\') {
                    dsu.union(root, root + 1);
                    dsu.union(root+2, root + 3);
                } 
                if(grid[r].charAt(c)!='/') {
                    dsu.union(root, root + 3);
                    dsu.union(root+1, root + 2);
                }
                // north-south
               if(r+1 < N) {
                   dsu.union(root+2, 4*((r+1)*N+c));    
               } 
               // east-west
               if(c+1 < N) {
                   dsu.union(root+3, root+5);
               }
            }            
        }
        int ans = 0;
        for(int i = 0 ; i < 4*N*N ; i++) {
            if(dsu.parent[i]==i)
              ans++;
        }
        return ans;
    }   

    class DSU {
        int [] parent ; 
        public DSU(int n) {
            parent = new int[n];
            for(int i =0; i < n ; i++)
                parent[i] = i;
        }

        private void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        private int find(int x) {
            if(parent[x]!=x)
               parent[x] = find(parent[x]);
            return parent[x];   
        }

    }
}
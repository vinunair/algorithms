package com.github.vinunair;

public class LongestCommonPrefixWithTrie {
    
    private TrieNode root = new TrieNode();

    class TrieNode {
        private TrieNode [] links;
        int R = 26;
        boolean isWord = false;
        int count ;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch-'a'] != null;
        }

        public void insert(char ch, TrieNode node ) {
            if(get(ch) == null) {
                links[ch -'a'] = node;
                count++;
            }
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean isWord() {
            return isWord;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        public int getChildCount() {
            return count;
        }
}

    public static void main(String args[]) {
        LongestCommonPrefixWithTrie lcpt = new LongestCommonPrefixWithTrie();
        LongestCommonPrefixWithTrie.TrieNode root =  lcpt.new TrieNode();
        //String [] strs = new String[] {"flower","flow","flight"};
        String [] strs = new String[] {"dog","racecar","car"};
        String searchWord = "flights";
        System.out.println("Search word " + searchWord+ ".Found -> " + lcpt.search(searchWord));
        System.out.println(lcpt.longestCommonPrefix(strs));
    }

    public void insert(String [] strs) {
        for(String str : strs) {
            TrieNode node = root;
            for(int i=0; i < str.length() ; i++) {
                if(!node.containsKey(str.charAt(i)))
                    node.insert(str.charAt(i), new TrieNode());
                 node = node.get(str.charAt(i));   
            }
                 node.setIsWord(true);
        }
    }

    public boolean search(String word) {
        TrieNode  node = root;
        for(int i=0; i< word.length();i++) {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));        
        }
        return node.isWord;
    }

    public String longestCommonPrefix(String[] strs) {
        insert(strs);
        String prefix = "";
        TrieNode node = root; 
        
        for(int i= 0; i < strs[0].length() ;i++) {
            if(node!=null && node.getChildCount() == 1 && !node.isWord) {
                prefix += strs[0].charAt(i);
                node = node.get(strs[0].charAt(i));
            }
            else
                break;    
        }

        return prefix;  
    }

}
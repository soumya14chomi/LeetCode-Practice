class WordDictionary {

    class Trie{
        String word;
        Trie[] next;

        Trie(){
            next = new Trie[26];
        }
    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie head = root;
        for(int i=0; i<word.length();i++){
            if(head.next[word.charAt(i)-'a'] == null){
                head.next[word.charAt(i)-'a'] = new Trie();
            }
            head = head.next[word.charAt(i)-'a'];
        }

        head.word = word;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    boolean searchHelper(String word, int idx, Trie root){
        if(idx == word.length())  {
            // System.out.println("from here " + word+ " and "+root.word);
             return root.word!=null;

        } 
        int ch = word.charAt(idx) - 'a';

        if(ch == -51){
            boolean res = false;
            for(int i=0; i< 26; i++){
                if(root.next[i]!=null) res = res || searchHelper(word, idx+1, root.next[i]);
            }
            return res;
        }

        else{
            if(root.next[ch] == null)   return false;
            return     searchHelper(word, idx+1, root.next[ch]);
        }   
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
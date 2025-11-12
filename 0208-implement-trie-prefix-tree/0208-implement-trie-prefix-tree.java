class Trie {

    class innerTrie{
        innerTrie[] child;

        boolean isword;

        innerTrie(){
            child = new innerTrie[26];
            isword = false;
        }
    }

    

    innerTrie trie = new innerTrie();
    
    public void insert(String word) {
        innerTrie temp = this.trie;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.child[ch-'a'] == null)
                 temp.child[ch-'a'] = new innerTrie();
            temp = temp.child[ch-'a']; 
        }

        temp.isword = true;
    }
    
    public boolean search(String word) {
        innerTrie temp = this.trie;
        for(char ch: word.toCharArray()){
            if(temp.child[ch-'a'] == null)   return false;
            temp = temp.child[ch-'a'];
        }
        if(temp.isword) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        innerTrie temp = this.trie;
        for(char ch: prefix.toCharArray()){
            if(temp.child[ch-'a'] == null)   return false;
            temp = temp.child[ch-'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
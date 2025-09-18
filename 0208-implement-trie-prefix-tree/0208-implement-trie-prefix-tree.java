class Trie {
    class Node{
        Character ch;
        // List<Node> lst;
        Map<Character, Node> hm;
        Node(Character ch){
            this.ch = ch;
            hm = new HashMap<>();
        }
        
    }
    Node root;
    public Trie() {
        root = new Node(null);
    }
    
    public void insert(String word) {
        Node head =this.root;
        for(int i=0; i<word.length();i++){
            if(!head.hm.containsKey(word.charAt(i))){
                head.hm.put(word.charAt(i), new Node(word.charAt(i)));
            }
            head = head.hm.get(word.charAt(i));
        }
        head.hm.put('.', null);
    }
    
    public boolean search(String word) {
         Node head =this.root;
        for(int i=0; i<word.length();i++){
            if(!head.hm.containsKey(word.charAt(i))){
                return false;
            }
            head = head.hm.get(word.charAt(i));
        }

        return head.hm.containsKey('.');
    }
    
    public boolean startsWith(String prefix) {
        Node head =this.root;
        for(int i=0; i<prefix.length();i++){
            if(!head.hm.containsKey(prefix.charAt(i))){
                return false;
            }
            head = head.hm.get(prefix.charAt(i));
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
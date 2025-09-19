class Solution {

    class Trie{
            String word;
            Trie[] next;

            Trie(){
                next = new Trie[26];
            }
        }

        Trie root = new Trie();

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

    public List<String> findWords(char[][] board, String[] words) {
        
        for(int i=0; i<words.length; i++)   addWord(words[i]);

        List<String> res = new ArrayList<>();

        int n = board.length, m = board[0].length;


        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                recursion(i, j, root, board, res);
            }
        } 

        return res;

    }


     void recursion(int i, int j, Trie root, char[][] board, List<String> res){
    

        if( board[i][j] == '*')  return;

        int ch = board[i][j] - 'a';
        if(root.next[ch]!=null){
            root=root.next[ch];
            board[i][j] = '*';
            if(i>0)                 recursion(i-1, j, root, board, res);
            if(j>0)    {
                // System.out.print(((char)(ch+'a')) + "->"+" ");
                 recursion(i, j-1, root, board, res);
            }            
            if(i<board.length-1)    recursion(i+1, j, root, board, res);
            if(j<board[0].length-1) recursion(i, j+1, root, board, res);
            board[i][j] = (char)('a'+ch);
        }   
        if(root.word!=null) {
            res.add(root.word);
            root.word = null;        
            }
        
     }

}
class Solution {
    public int maxProduct(String[] words) {
        int[] values = new int[words.length];

        for(int i=0;i<words.length;i++){
            for(int j=0; j<words[i].length(); j++){
                values[i] = values[i] | (1<<words[i].charAt(j) - 'a');
            
            }
        }

        int res =0;

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(((values[i] & values[j]) == 0) && (words[i].length() * words[j].length()) > res) 
                    res = words[i].length() * words[j].length();
            }
        }

        return res;
    }
}
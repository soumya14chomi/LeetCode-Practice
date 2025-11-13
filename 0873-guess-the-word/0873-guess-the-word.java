/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        HashMap<String, Integer> criteria = new HashMap<>();

        Random random = new Random();
        while(true) {

            String guess = words[random.nextInt(words.length)];
            if(!criteria.containsKey(guess) && criteriaMatch(guess, criteria)) {
                System.out.println("Calling with:"+guess);
                int match = master.guess(guess);
                if(match == 6)  return;
                criteria.put(guess, match);
            }

            // System.out.println(criteria.toString());
        }
    }

    int match(String str1, String str2){
        int res= 0;
        for(int i=0; i<6; i++){
            if(str1.charAt(i) == str2.charAt(i))   res++;
        }
        // System.out.println(str1+" "+str2+" : "+res);
        return res;
    }

    boolean criteriaMatch(String str, HashMap<String, Integer> hm){
        for(String s: hm.keySet()){
            if(match(str, s) != hm.get(s))  return false;
        }

        return true;
    }
}
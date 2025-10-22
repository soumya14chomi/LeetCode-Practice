import java.util.*;

class Solution {

    HashMap<String, List<Integer>> hm = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        if(hm.containsKey(expression))  return hm.get(expression);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        int result = 0;
                        if (oper == '+') result = (a + b);
                        else if (oper == '-') result = (a - b);
                        else if (oper == '*') result = (a * b);
                        res.add(result);
                    }
                }
            }
        }
        
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        hm.put(expression, res);
        return res;
    }
}
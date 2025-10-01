class Solution {
    public List<Integer> grayCode(int n) {
        List<String> res  = new ArrayList<>();

        res.add("0");
        res.add("1");

        for(int i=1; i<n; i++){
            List<String> temp = new ArrayList<>(res);
            for(int j=0; j<temp.size(); j++){
                res.set(j, "0"+temp.get(j));
            }

            for(int j=temp.size()-1; j>=0; j--){
                res.add("1"+temp.get(j));
            }
            System.out.println(res);
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<res.size(); i++){
            arr.add(convertToDec(res.get(i)));
        }

        return arr;
    }

    int convertToDec(String str){
        int res = 0;
        for(int i=0; i<str.length();i++){
            res+=(Math.pow(2, i)*((int)str.charAt(i)-'0'));
        }

        return res;
    }
}
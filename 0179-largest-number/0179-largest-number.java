class Solution {
    public String largestNumber(int[] nums) {

        int n= nums.length;
        String[] strs = new String[n];

        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<n; i++)  strs[i] = String.valueOf(nums[i]);

        int max = 0;

        for(int i=0; i<n; i++){
            if(max<strs[i].length()){
                max = strs[i].length();
            }
        }

       Arrays.sort(strs, (a, b) -> {
        int i=0;
            while (i < a.length() && i < b.length()) {
                if (a.charAt(i) != b.charAt(i)) {
                    return b.charAt(i) - a.charAt(i); // reverse lexicographical
                }
                i++;
            }

            if(b.length() > a.length()){
                int j=0;

                while(i<b.length()){
                    // System.out.println("comparing:"+b.charAt(i) + " "+a.charAt(j));

                    if(a.charAt(j) != b.charAt(i)) return b.charAt(i) - a.charAt(j);
                    i = (i+1)%b.length();
                    j = (j+1)%a.length();


                    if(i==0 && j==0) break;
                }
            }

            else{
                int j=0;

                while(i<a.length()){
                    if(b.charAt(j) != a.charAt(i))  return b.charAt(j) - a.charAt(i);
                    i = (i+1)%a.length();
                    j = (j+1)%b.length();

                    if(i==0 && j==0)    break;
                }

            }
            
            return b.length() - a.length(); // longer string comes first
        });

        String res = "";
        for(int i=0; i<n;i++){
            res+=strs[i];
        }

        while(res.length()>1 && res.startsWith("0"))  res = res.substring(1);

        return res;
    }
}
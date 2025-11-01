class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // int prev = -1;


        int n = nums.length;

        for(int i=0; i<nums.length; i++){

            
            HashSet<Integer> hs = new HashSet<>();

            // if(((i+nums[i])%n + n)%n == i)  continue;

            int idx = i;
            int start = i, k=0;

            do {
                // System.out.print(idx+" ");
                k++;
                hs.add(idx);
                int temp = ((idx+nums[idx])%n + n)%n;
                if((nums[start] > 0 && nums[temp] < 0) || (nums[start]< 0 && nums[temp] > 0))    break;
                idx = temp;

            }
            while(idx!=start && !hs.contains(idx));

            System.out.println();

            if(idx == start && k>1)    return true;

        }

        return false;
    }
}
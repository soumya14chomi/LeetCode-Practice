class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(height[i], max);
            left[i] = max;
        }

        int res=0;
        max= Integer.MIN_VALUE;

        // System.out.p/rintln(Arrays.toString(left));

        for(int i=n-1;i>=0;i--){
            max = Math.max(height[i], max);

            res+= (Math.min(left[i], max) - height[i]);
        }

        return res;
    }
}
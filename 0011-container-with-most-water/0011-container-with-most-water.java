class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0, j=height.length-1; i<j; ){
            int area = Math.min(height[i], height[j])*(j-i);
            max = Math.max(max, area);
            int h = Math.min(height[i], height[j]);
            while(i<j && height[i]<=h)   i++;
            while(i<j && height[j]<=h)   j--;
        }

        return max;
    }
}
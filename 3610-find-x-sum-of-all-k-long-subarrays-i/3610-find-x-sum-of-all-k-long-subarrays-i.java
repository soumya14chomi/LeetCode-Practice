class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] count = new int[51];

        int n = nums.length;

        int[] res = new int[n-k+1];

        for(int i=0;i<k; i++)   count[nums[i]]++;

        for(int i=k; i<=n; i++){
           PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) ->{
            if(count[a] == count[b])    return a-b;

            return count[a] - count[b];
           });

           int sum = 0; 

           for(int j=i-k; j<i; j++){

                // System.out.println("Adding: "+ nums[j] + " to : "+pq.toString());
                if(pq.contains(nums[j]))    pq.remove(nums[j]);
                

                pq.add(nums[j]);
                //  System.out.println("Added: "+ nums[j] + " to : "+pq.toString());

                if(pq.size() > x)   pq.poll();

           }
            System.out.println(pq.toString());
           while(!pq.isEmpty()){
            int top = pq.poll();

            // System.out.println("top : "+top+" count: "+count[top]);

            sum = sum+ (top*count[top]);
           }

           res[i-k] = sum;

           count[nums[i-k]]--;
           if(i<n)  count[nums[i]]++;

        }

        return res;
    }
}
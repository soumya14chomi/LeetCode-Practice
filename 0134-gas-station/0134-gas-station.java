class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int totalGas = 0; 
        int totalCost = 0;

        for(int i=0;i<cost.length;i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalGas < totalCost)    return -1;
        int start =0;
        int total =0;

        for(int i=0;i<cost.length;i++){
            total += gas[i]-cost[i];
            if(total<0){
                start = i+1;
                total=0;
            
            }
            
        }
        return start;
        
    }
}
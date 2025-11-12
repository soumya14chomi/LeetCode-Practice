class StockSpanner {

    Stack<int[]> st;


    public StockSpanner() {
        st = new Stack<>();
        
    }
    
    public int next(int price) {
        int res =0;
        while(!st.isEmpty() && st.peek()[0] <= price){
            res+=st.peek()[1] + 1;
            st.pop();
        }
        st.push(new int[]{price, res});

        return res+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
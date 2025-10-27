class Bank {

    long[] bank;

    public Bank(long[] balance) {
        bank = balance;
    }
    
    public boolean transfer(int acc1, int acc2, long money) {
        if(acc1<=bank.length && acc2 <= bank.length && bank[acc1-1] >= money){
             bank[acc1-1]-=money;
             bank[acc2-1]+=money;
             return true;
        }

        return  false;
    }
    
    public boolean deposit(int account, long money) {
        if(account > bank.length)  return false;
        bank[account-1]+=money;

        return true;

    }
    
    public boolean withdraw(int account, long money) {


        if(account<=bank.length && bank[account-1]>=money){
            bank[account-1]-=money;
            return true;
        }

        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
public class Account {
    public Account(long AccountNumber,String Name){
        this.AccountNumber=AccountNumber;
        this.Name=Name;
        this.RestMoney=0;
    }
    private long AccountNumber;
    private String Name;
    private int RestMoney;
    long getAccountNumber(){
        return this.AccountNumber;
    }
    String getName(){
        return this.Name;
    }
    int getRestMoney(){
        return this.RestMoney;
    }
    void Deposit(int Money){
        this.RestMoney+=Money;
    }
    void Withdrawal(int Money){
        this.RestMoney-=Money;
    }
    void PrintUserInFo(){
        System.out.print("계좌번호: "+AccountNumber+" / ");
        System.out.print("이름: "+Name+" / ");
        System.out.println("잔액: "+RestMoney);
    }
//    Account MakeAccount(int accountNumber, String name){
//        Account NewAccount=new Account(accountNumber,name);
//        return NewAccount;
//    }
}

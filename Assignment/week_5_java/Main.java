import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> TotalAccount=new ArrayList<>();
        Account NewAccount;
        Scanner sc=new Scanner(System.in);
        boolean end=true;
        while(end) {
            System.out.println("===================Bank Menu======================");
            System.out.println("1: 계좌개설");
            System.out.println("2. 입금하기");
            System.out.println("3. 출금하기");
            System.out.println("4. 전체조회");
            System.out.println("5. 계좌이체");
            System.out.println("6. 프로그램 종료");
            int pointer ;
            try {
                pointer = sc.nextInt();
                switch (pointer) {
                    case 1:
                        System.out.println("===================계좌개설 메뉴======================");
                        System.out.println("이름을 입략해주세요: ");
                        Scanner scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        long accountNumber = (long) (Math.random() * 1000000000);
                        NewAccount = new Account(accountNumber, name);
                        TotalAccount.add(NewAccount);
                        System.out.printf("%s의 계좌생성이 완료 되었습니다!\n", name);
                        System.out.printf("계좌번호는 %d 입니다\n", accountNumber);
                        break;
                    case 2:
                        System.out.println("===================입금하기 메뉴======================");
                        System.out.println("입금할 계좌번호를 입력해주세요: ");
                        boolean again = true;
                        do {
                            long DepositAccount = sc.nextLong();
                            for (Account i : TotalAccount) {
                                if (i.getAccountNumber() == DepositAccount) {
                                    System.out.println("얼마를 입급하시겠습니까?");
                                    int Money = sc.nextInt();
                                    i.Deposit(Money);
                                    System.out.println("입금이 완료되었습니다");
                                    again = false;
                                    break;
                                }
                            }
                            if (again) {
                                System.out.println("해당되는 계좌번호가 없습니다");
                                System.out.println("입금할 계좌번호를 입력해주세요: ");
                            }
                        } while (again);
                        break;
                    case 3:
                        System.out.println("===================출금하기 메뉴======================");
                        System.out.println("출금할 계좌번호를 입력해주세요: ");
                        boolean oneMore = true;
                        do {
                            long DepositAccount = sc.nextLong();
                            for (Account i : TotalAccount) {
                                if (i.getAccountNumber() == DepositAccount) {
                                    System.out.println("얼마를 출금하시겠습니까?");
                                    int Money = sc.nextInt();
                                    while (Money > i.getRestMoney()) {
                                        System.out.println("잔액이 부족합니다");
                                        Money = sc.nextInt();
                                    }
                                    i.Withdrawal(Money);
                                    System.out.println("출금이 완료되었습니다");
                                    oneMore = false;
                                    break;
                                }
                            }
                            if (oneMore)
                                System.out.println("해당되는 계좌번호가 없습니다");
                        } while (oneMore);
                        break;
                    case 4:
                        for (int i = 0; i < TotalAccount.size(); i++) {
                            TotalAccount.get(i).PrintUserInFo();
                        }
                        break;
                    case 5:
                        System.out.println("===================송금하기 메뉴======================");
                        System.out.println("출금할 계좌번호를 입력해주세요: ");
                        Scanner sc2 = new Scanner(System.in);
                        boolean ee = true;
                        do {
                            long DepositAccount = sc.nextLong();
                            for (Account out : TotalAccount) {
                                if (out.getAccountNumber() == DepositAccount) {
                                    do {
                                        System.out.println("돈을 보낼 계좌를 입력하세요:");
                                        long GetAccount = sc2.nextLong();
                                        for (Account in : TotalAccount) {
                                            if (in.getAccountNumber() == GetAccount) {
                                                System.out.println("얼마를 송금하시겠습니까?");
                                                int Money = sc.nextInt();
                                                while (Money > out.getRestMoney()) {
                                                    System.out.println("잔액이 부족합니다");
                                                    Money = sc.nextInt();
                                                }
                                                out.Withdrawal(Money);
                                                in.Deposit(Money);
                                                System.out.println("입금이 완료되었습니다");
                                                ee = false;
                                                break;
                                            }
                                        }
                                    } while (ee);
                                }
                            }
                            if (ee)
                                System.out.println("해당되는 계좌번호가 없습니다");
                        } while (ee);
                        break;
                    case 6:
                        end = false;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다");
                        break;
                }
            }
            catch (InputMismatchException e){
                sc =new Scanner(System.in);
                System.out.println("예외 발생! 숫자만 입력해주세요:");
            }
        }
    }
}
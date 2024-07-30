import java.util.*;
public class CreditCardPayment implements PaymentStrategy {
    private int amount;
    public void pay(){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter amount to pay through credit card: ");
        int a=sc.nextInt();
        this.amount=a;
        System.out.println("the amount need to pay through credit card: "+this.amount);
    }
}

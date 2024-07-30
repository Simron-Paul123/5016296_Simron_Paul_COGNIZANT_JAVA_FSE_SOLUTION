import java.util.*;

public class Adaptee_2 {
    public int send_amount(){
        System.out.print("enter amount to send: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //sc.close();
        return n;
    }
}

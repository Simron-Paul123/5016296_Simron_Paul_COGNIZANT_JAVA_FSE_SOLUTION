import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        StockMarket stock=new StockMarket();
        //stock.register(new MobileApp());
        MobileApp m=new MobileApp();
        stock.register(m);
        stock.register(new WebApp());
        stock.deregister(m);
        Scanner sc=new Scanner(System.in);
        System.out.println("enter price to update: ");
        stock.update_price(sc.nextInt());
    }
}

import java.util.*;
public class StockMarket implements Stock{
    private int price;
    private List<Observer> observer=new ArrayList<>();
    public void register(Observer observe) { 
        observer.add(observe);
        System.out.println("observer is registered");
    }
    public void deregister(Observer observe){
        observer.remove(observe);
        System.out.println("observer is deregistered");
    }
    public void Notify(){
        for(Observer observe : observer)
            observe.update();
        System.out.println("observer is notified");
    }
    public void update_price(int price){
        this.price=price;
        Notify();
    }
}

public class Adapter2 implements PaymentProcessor {
    private Adaptee_2 adaptee_2;
    Adapter2(Adaptee_2 adaptee){
        this.adaptee_2 = adaptee;
    }
    public int processPayment(){
        System.out.println("the payment of adaptee_2 is processed by adapter2 which implements PaymentProcessor");
        return adaptee_2.send_amount();
    }
}

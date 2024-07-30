public class Adapter1 implements PaymentProcessor {
    private Adaptee_1 adaptee_1;
    Adapter1(Adaptee_1 adaptee){
        this.adaptee_1 = adaptee;
    }
    public int processPayment(){
        System.out.println("the payment of adaptee_1 is processed by adapter1 which implements PaymentProcessor");
        return adaptee_1.send_amount();
    }
}

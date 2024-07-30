public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Adapter1 a=new Adapter1(new Adaptee_1());
        System.out.println("the amount of money that is sent by the adaptee1 and processed by PaymentProcessor through Adapter1 is: "+a.processPayment());
        Adapter2 b=new Adapter2(new Adaptee_2());
        System.out.println("the amount of money that is sent by the adaptee2 and processed by PaymentProcessor through Adapter2 is: "+b.processPayment());
    }
}

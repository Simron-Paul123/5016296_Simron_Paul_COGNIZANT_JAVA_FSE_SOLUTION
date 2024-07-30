public class PaymentContext  {
    private PaymentStrategy _paymentStrategy;
    public void execute_strategy(PaymentStrategy p){
        this._paymentStrategy = p;
        _paymentStrategy.pay();
        System.out.println("Payment Processed through execute strategy method");

    }
}

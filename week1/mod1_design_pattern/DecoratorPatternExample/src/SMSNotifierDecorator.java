public class SMSNotifierDecorator extends  NotifierDecorator{
    SMSNotifierDecorator(Notifier notify){
        super(notify);
    }
    public String send(){
        String s= super.send();
        System.out.println(s);
        return "message send through SMS";
    }
}

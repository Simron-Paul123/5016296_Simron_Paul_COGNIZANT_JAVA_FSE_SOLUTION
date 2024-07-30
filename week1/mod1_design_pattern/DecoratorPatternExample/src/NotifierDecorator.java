abstract class NotifierDecorator implements Notifier {
    protected Notifier notify;
    NotifierDecorator(Notifier notify) {
        this.notify = notify;
    }
    public String send(){
        return notify.send();
    }
}

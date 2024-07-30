public class SlackNotifierDecorator extends NotifierDecorator  {
    SlackNotifierDecorator(EmailNotifier emailNotifier) {
        super(emailNotifier);
    }
    public String send(){
        String s= super.send();
        System.out.println(s);
        return "Slack message send";
    }
}

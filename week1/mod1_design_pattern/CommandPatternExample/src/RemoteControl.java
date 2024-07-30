public class RemoteControl {
    private Command command;
    RemoteControl(Command command) {
        this.command = command;
    }
    public void execute(Light light){
        command.execute(light);
    }
}

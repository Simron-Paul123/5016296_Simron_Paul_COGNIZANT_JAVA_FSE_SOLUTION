// create light class with turnon and off
//create command interface
//when the command is lighton -> light.turnon
//when the command is lightoff->light.turnoff
//pass the command to remote control
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        RemoteControl remote = new RemoteControl(new LightOnCommand()); //new command to on the light
        Light light=new Light();
        remote.execute(light);
        remote = new RemoteControl(new LightOffCommand());//new command to turn off the same light
        remote.execute(light);


    }
}

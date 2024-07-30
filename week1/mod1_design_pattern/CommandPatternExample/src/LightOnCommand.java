public class LightOnCommand implements Command {

    public void execute(Light light){
        light.turn_on();
    }
}

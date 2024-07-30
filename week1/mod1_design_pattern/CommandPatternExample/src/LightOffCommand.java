public class LightOffCommand implements Command {
    public void execute(Light light){
        light.turn_off();
        
    }
}
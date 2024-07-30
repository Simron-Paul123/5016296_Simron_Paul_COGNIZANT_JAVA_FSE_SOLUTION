public class RealImage implements Image {
    private String file_name;
    RealImage(String file_name) {
        this.file_name = file_name;
        loader_image();
    }
    private void loader_image(){
        System.out.println(file_name+"-> image is loaded");
    }
    public void display() {
        System.out.println("the name of the image which is displayed is: "+file_name);
    }
}

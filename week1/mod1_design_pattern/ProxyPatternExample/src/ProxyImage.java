public class ProxyImage implements Image{
    private RealImage image;
    private String file_name;
    ProxyImage(RealImage image,String file) {
        this.image = image;
        this.file_name = file;
    }
    public void display(){
        if(image==null){
            image= new RealImage(file_name);
        }
        image.display();
    }
}

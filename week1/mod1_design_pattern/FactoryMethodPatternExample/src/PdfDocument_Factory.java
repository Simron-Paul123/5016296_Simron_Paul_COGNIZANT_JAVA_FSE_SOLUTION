public class PdfDocument_Factory  extends DocumentFactory  {
    public document createDocument(){
        System.out.println("word documnet object created inside PdfDocument_Factory class\tthe class extended abstract class");
        return new PdfDocument();
    }
}
